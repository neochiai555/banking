package com.ochiai.banking.mensageria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public abstract class MensageriaServicoImpl implements MensageriaServico {
	
	@Autowired
	protected KafkaTemplate<String, String> kafkaTemplate;
	
	public interface TratamentoRetornoMensagem {
		void sucesso(String mensagem);
		void erro(Throwable t);		
	}
	
	public MensageriaServicoImpl() {
		
	}

	@Override
	public abstract void enviar(String topico, String chave, String mensagem);
	
	@Override
	public abstract void receber(String mensagem);
	
	public void enviar(String topico, String chave, String mensagem, TratamentoRetornoMensagem callback) {
        
	    ListenableFuture<SendResult<String, String>> future = 
	      kafkaTemplate.send(topico, chave, mensagem);
		
	    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	        @Override
	        public void onSuccess(SendResult<String, String> result) {
	            System.out.println("Sent message=[" + mensagem + 
	              "] with offset=[" + result.getRecordMetadata().offset() + "]");
	            
	            callback.sucesso(mensagem);
	        }
	        @Override
	        public void onFailure(Throwable ex) {
	            System.out.println("Unable to send message=[" 
	              + mensagem + "] due to : " + ex.getMessage());
	            
	            callback.erro(ex);
	        }
	    });
	}	

	/*
	@KafkaListener(topics = TOPICO_INVOCACAO_TRANSACAO_CARTAO, groupId = GRUPO_INVOCACAO_TRANSACAO_CARTAO)
	public void receberInvocacaoTransacaoCartao(String message) {
	    System.out.println("Received Message: " + message);
	    
	    callbackInvocacaoTransacaoCartao.tratar(message);
	}
	
	@KafkaListener(topics = TOPICO_RETORNO_TRANSACAO_CARTAO, groupId = GRUPO_RETORNO_TRANSACAO_CARTAO)
	public void receberRetornoTransacaoCartao(String message) {
	    System.out.println("Received Message: " + message);
	    
	    callbackRetornoTransacaoCartao.tratar(message);
	}

	@KafkaListener(topics = TOPICO_INVOCACAO_TRANSACAO_CONTA, groupId = GRUPO_RETORNO_TRANSACAO_CONTA)
	public void receberInvocacaoTransacaoConta(String message) {
	    System.out.println("Received Message: " + message);
	    
	    callbackInvocacaoTransacaoConta.tratar(message);
	}

	@KafkaListener(topics = TOPICO_RETORNO_TRANSACAO_CONTA, groupId = GRUPO_RETORNO_TRANSACAO_CONTA)
	public void receberRetornoTransacaoConta(String message) {
	    System.out.println("Received Message: " + message);
	    
	    callbackRetornoTransacaoConta.tratar(message);
	}
	*/
}
