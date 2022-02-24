package com.ochiai.banking.card.rest.mensageria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.service.MovimentacaoCartaoServico;
import com.ochiai.banking.mensageria.model.TransacaoCartao;
import com.ochiai.banking.mensageria.service.MensageriaServicoCartaoImpl;

@Service
public class MensageriaServicoCartao extends MensageriaServicoCartaoImpl {
	
	@Autowired 
	MovimentacaoCartaoServico movimentacaoCartaoServico;
	
	public void enviar(TransacaoCartao transacao) {
		enviar(TOPICO_INVOCACAO_TRANSACAO_CARTAO, transacao.getIdentificadorCartao(), transacao);
	}

	@Override
	protected void enviar(String topico, String chave, TransacaoCartao transacao) {
		enviar(topico, chave, transacao, new TratamentoRetornoMensagemCartao() {
			
			@Override
			public void sucesso(TransacaoCartao transacao) {
				System.out.println("Mensagem de transacao enviada com sucesso: " + transacao.toString());
			}
			
			@Override
			public void erro(Throwable t) {
				System.out.println("Erro no envio de transacao: " + t.getMessage());
			}
		});
	}

	@Override
	@KafkaListener(topics = TOPICO_RETORNO_TRANSACAO_CARTAO, groupId = GRUPO_RETORNO_TRANSACAO_CARTAO,
			containerFactory = "transacaoCartaoKafkaListenerContainerFactory")
	protected void receber(TransacaoCartao transacao) {
		if (transacao.getProcessada()) {
			System.out.println("Transacao de conta completada: " + transacao.toString());
		} else {
			try {
				movimentacaoCartaoServico.estorno(transacao.getData(), transacao.getValor(), transacao.getNumeroCartao());
			} catch (Exception ex) {
				System.out.println("Erro na transacao de conta: " + ex.getMessage());
			}
		}
	}
}

