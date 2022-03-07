package com.ochiai.banking.card.rest.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.service.MovimentacaoCartaoServico;
import com.ochiai.banking.messaging.model.TransacaoCartao;
import com.ochiai.banking.messaging.service.CartaoBaseMessagingService;

@Service
public class CartaoMessagingService extends CartaoBaseMessagingService {
	Logger logger = LoggerFactory.getLogger(CartaoMessagingService.class);
	
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
				logger.info("Mensagem de transacao enviada com sucesso: " + transacao.toString());
			}
			
			@Override
			public void erro(Throwable t) {
				logger.error("Erro no envio de transacao: " + t.getMessage());
			}
		});
	}

	@Override
	@KafkaListener(topics = TOPICO_RETORNO_TRANSACAO_CARTAO, groupId = GRUPO_RETORNO_TRANSACAO_CARTAO,
			containerFactory = "transacaoCartaoKafkaListenerContainerFactory")
	protected void receber(TransacaoCartao transacao) {
		if (transacao.getProcessada()) {
			logger.info("Transacao de conta completada: " + transacao.toString());
		} else {
			try {
				movimentacaoCartaoServico.estorno(transacao.getData(), transacao.getValor(), transacao.getNumeroCartao());
			} catch (Exception ex) {
				logger.error("Erro na transacao de conta: " + ex.getMessage());
			}
		}
	}
}

