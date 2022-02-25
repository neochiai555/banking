package com.ochiai.banking.rest.mensageria;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.Cartao;
import com.ochiai.banking.core.persistence.entity.Conta;
import com.ochiai.banking.core.persistence.service.CartaoServico;
import com.ochiai.banking.core.persistence.service.MovimentacaoContaServico;
import com.ochiai.banking.mensageria.model.TransacaoCartao;
import com.ochiai.banking.mensageria.service.MensageriaServicoContaBase;

@Service
public class MensageriaServicoConta extends MensageriaServicoContaBase {
	Logger logger = LoggerFactory.getLogger(MensageriaServicoConta.class);
	
	@Autowired 
	MovimentacaoContaServico movimentacaoContaServico;

	@Autowired 
	CartaoServico cartaoServico;

	public void enviar(TransacaoCartao transacao) {
		enviar(TOPICO_RETORNO_TRANSACAO_CARTAO, transacao.getIdentificadorCartao(), transacao);
	}

	@Override
	protected void enviar(String topico, String chave, TransacaoCartao transacao) {
		enviar(topico, chave, transacao, new TratamentoRetornoMensagemCartao() {
			
			@Override
			public void sucesso(TransacaoCartao transacao) {
				logger.info("Mensagem de transacao enviada com sucesso: " + transacao.toString());
			}
			
			@Override
			public void erro(Throwable t) {
				logger.error("Erro no envio de transacao: " + t.getMessage());
			}
		});
	}

	@Override
	@KafkaListener(topics = TOPICO_INVOCACAO_TRANSACAO_CARTAO, groupId = TOPICO_INVOCACAO_TRANSACAO_CARTAO,
			containerFactory = "transacaoCartaoKafkaListenerContainerFactory")
	protected void receber(TransacaoCartao transacao) {
		try {
			List<Cartao> cartoes = cartaoServico.findByNumeroCartao(transacao.getNumeroCartao());
			
			if (cartoes == null || cartoes.isEmpty()) {
				logger.error("Cartao nao encontrado: " + transacao.getNumeroCartao());	
				return;
			}

			if (cartoes.size() > 1) {
				logger.error("Cartao duplicado: " + transacao.getNumeroCartao());	
				return;
			}

			Cartao cartao = cartoes.get(0);
			
			Conta conta = cartao.getConta();
			
			movimentacaoContaServico.saque(transacao.getData(), transacao.getValor(),
				conta.getNumeroAgencia(), conta.getDigitoAgencia(),
				conta.getNumero(), conta.getDigito()
				);
			
			transacao.setProcessada(true);
			enviar(transacao);
		} catch (Exception ex) {
			transacao.setProcessada(false);
			enviar(transacao);
			logger.error("Erro na transacao de saque na conta: " + ex.getMessage());
		}
	}
}
