package com.ochiai.banking.mensageria.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.ochiai.banking.mensageria.model.TransacaoCartao;
import com.ochiai.banking.mensageria.model.TransacaoConta;

@Service
public abstract class MensageriaServicoContaImpl implements MensageriaServico {
	
	@Autowired
	protected KafkaTemplate<String, TransacaoConta> kafkaTemplateConta;
	
	public interface TratamentoRetornoMensagemConta {
		void sucesso(TransacaoConta transacao);
		void erro(Throwable t);		
	}

	public MensageriaServicoContaImpl() {
		
	}

	protected abstract void enviar(String topico, String chave, TransacaoConta transacao);
	
	protected abstract void receber(TransacaoCartao transacao);
	
	protected void enviar(String topico, String chave, TransacaoConta transacao, TratamentoRetornoMensagemConta callback) {
        
	    ListenableFuture<SendResult<String, TransacaoConta>> future = 
	    		kafkaTemplateConta.send(topico, chave, transacao);
		
	    future.addCallback(new ListenableFutureCallback<SendResult<String, TransacaoConta>>() {

	        @Override
	        public void onSuccess(SendResult<String, TransacaoConta> result) {
	            System.out.println("Sent message=[" + transacao.toString() + 
	              "] with offset=[" + result.getRecordMetadata().offset() + "]");
	            
	            callback.sucesso(transacao);
	        }
	        @Override
	        public void onFailure(Throwable ex) {
	            System.out.println("Unable to send message=[" 
	              + transacao.toString() + "] due to : " + ex.getMessage());
	            
	            callback.erro(ex);
	        }
	    });
	}
}
