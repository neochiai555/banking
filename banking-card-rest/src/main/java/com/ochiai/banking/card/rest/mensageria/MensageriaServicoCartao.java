package com.ochiai.banking.card.rest.mensageria;

import org.springframework.kafka.annotation.KafkaListener;

import com.ochiai.banking.mensageria.service.MensageriaServicoImpl;

public class MensageriaServicoCartao extends MensageriaServicoImpl {
	@Override
	public void enviar(String topico, String chave, String mensagem) {
		enviar(topico, chave, mensagem, new TratamentoRetornoMensagem() {
			
			@Override
			public void sucesso(String mensagem) {
			}
			
			@Override
			public void erro(Throwable t) {
			}
		});
	}

	@Override
	@KafkaListener(topics = TOPICO_RETORNO_TRANSACAO_CARTAO, groupId = GRUPO_RETORNO_TRANSACAO_CARTAO)
	public void receber(String mensagem) {
		
	}
}
