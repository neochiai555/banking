package com.ochiai.banking.rest.mensageria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.service.MovimentacaoContaServico;
import com.ochiai.banking.mensageria.model.TransacaoConta;
import com.ochiai.banking.mensageria.service.MensageriaServicoContaImpl;

@Service
public class MensageriaServicoConta extends MensageriaServicoContaImpl {
	
	@Autowired 
	MovimentacaoContaServico movimentacaoContaServico;
	
	public void enviar(TransacaoConta transacao) {
		// Por hora nada, este e o fim da cadeia de eventos
	}
	
	@Override
	protected void enviar(String topico, String chave, TransacaoConta transacao) {
		// Por hora nada, este e o fim da cadeia de eventos
	}

	@Override
	@KafkaListener(topics = TOPICO_INVOCACAO_TRANSACAO_CONTA, groupId = TOPICO_INVOCACAO_TRANSACAO_CONTA)
	protected void receber(TransacaoConta transacao) {
		try {
			movimentacaoContaServico.saque(transacao.getData(), transacao.getValor(),
				transacao.getNumeroAgencia(), transacao.getDigitoAgencia(),
				transacao.getNumeroConta(), transacao.getDigitoConta()
				);
		} catch (Exception ex) {
			System.out.println("Erro na transacao de saque na conta: " + ex.getMessage());
		}
	}
}
