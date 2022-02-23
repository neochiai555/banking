package com.ochiai.banking.card.rest.mensageria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.service.MovimentacaoContaServico;
import com.ochiai.banking.mensageria.model.TransacaoConta;
import com.ochiai.banking.mensageria.service.MensageriaServicoCartaoImpl;

@Service
public class MensageriaServicoCartao extends MensageriaServicoCartaoImpl {
	
	@Autowired 
	MovimentacaoContaServico movimentacaoContaServico;
	
	public void enviar(TransacaoConta transacao) {
		enviar(TOPICO_INVOCACAO_TRANSACAO_CONTA, transacao.getIdentificadorConta(), transacao);
	}

	@Override
	protected void enviar(String topico, String chave, TransacaoConta transacao) {
		enviar(topico, chave, transacao, new TratamentoRetornoMensagemConta() {
			
			@Override
			public void sucesso(TransacaoConta transacao) {
				System.out.println("Mensagem de transacao enviada com sucesso: " + transacao.toString());
			}
			
			@Override
			public void erro(Throwable t) {
				System.out.println("Erro no envio de transacao: " + t.getMessage());
			}
		});
	}

	@Override
	@KafkaListener(topics = TOPICO_RETORNO_TRANSACAO_CONTA, groupId = GRUPO_RETORNO_TRANSACAO_CONTA)
	protected void receber(TransacaoConta transacao) {
		if (transacao.getSucesso()) {
			System.out.println("Transacao de conta completada: " + transacao.toString());
		} else {
			try {
				movimentacaoContaServico.deposito(transacao.getData(), transacao.getValor(),
						transacao.getNumeroAgencia(), transacao.getDigitoAgencia(),
						transacao.getNumeroConta(), transacao.getDigitoConta()
						);
			} catch (Exception ex) {
				System.out.println("Erro na transacao de conta: " + ex.getMessage());
			}
		}
	}
}

