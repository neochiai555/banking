package com.ochiai.banking.messaging.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.ochiai.banking.messaging.model.TransacaoCartao;

@Service
public abstract class CartaoBaseMessagingService implements MessagingService {
	Logger logger = LoggerFactory.getLogger(CartaoBaseMessagingService.class);
	
	@Autowired
	protected KafkaTemplate<String, TransacaoCartao> kafkaTemplateCartao;
	
	public interface TratamentoRetornoMensagemCartao {
		void sucesso(TransacaoCartao transacao);
		void erro(Throwable t);		
	}

	protected CartaoBaseMessagingService() {
		
	}

	protected abstract void enviar(String topico, String chave, TransacaoCartao transacao);
	
	protected abstract void receber(TransacaoCartao transacao);
	
	protected final void enviar(String topico, String chave, TransacaoCartao transacao, TratamentoRetornoMensagemCartao callback) {
        
	    ListenableFuture<SendResult<String, TransacaoCartao>> future = 
	    		kafkaTemplateCartao.send(topico, chave, transacao);
		
	    future.addCallback(new ListenableFutureCallback<SendResult<String, TransacaoCartao>>() {

	        @Override
	        public void onSuccess(SendResult<String, TransacaoCartao> result) {
	            logger.info("Sent message=[" + transacao.toString() + 
	              "] with offset=[" + result.getRecordMetadata().offset() + "]");
	            
	            callback.sucesso(transacao);
	        }
	        @Override
	        public void onFailure(Throwable ex) {
	            logger.error("Unable to send message=[" 
	              + transacao.toString() + "] due to : " + ex.getMessage());
	            
	            callback.erro(ex);
	        }
	    });
	}
}
