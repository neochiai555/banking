package com.ochiai.banking.rest.mensageria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.Cartao;
import com.ochiai.banking.core.persistence.entity.Conta;
import com.ochiai.banking.core.persistence.service.CartaoServico;
import com.ochiai.banking.core.persistence.service.MovimentacaoContaServico;
import com.ochiai.banking.mensageria.model.TransacaoCartao;
import com.ochiai.banking.mensageria.model.TransacaoConta;
import com.ochiai.banking.mensageria.service.MensageriaServicoContaImpl;

@Service
public class MensageriaServicoConta extends MensageriaServicoContaImpl {
	
	@Autowired 
	MovimentacaoContaServico movimentacaoContaServico;

	@Autowired 
	CartaoServico cartaoServico;

	public void enviar(TransacaoConta transacao) {
		// Por hora nada, este e o fim da cadeia de eventos
	}
	
	@Override
	protected void enviar(String topico, String chave, TransacaoConta transacao) {
		// Por hora nada, este e o fim da cadeia de eventos
	}

	@Override
	@KafkaListener(topics = TOPICO_INVOCACAO_TRANSACAO_CARTAO, groupId = TOPICO_INVOCACAO_TRANSACAO_CARTAO)
	protected void receber(TransacaoCartao transacao) {
		try {
			List<Cartao> cartoes = cartaoServico.findByNumeroCartao(transacao.getNumeroCartao());
			
			if (cartoes == null || cartoes.isEmpty()) {
				System.out.println("Cartao nao encontrado: " + transacao.getNumeroCartao());	
				return;
			}

			if (cartoes.size() > 1) {
				System.out.println("Cartao duplicado: " + transacao.getNumeroCartao());	
				return;
			}

			Cartao cartao = cartoes.get(0);
			
			Conta conta = cartao.getConta();
			
			movimentacaoContaServico.saque(transacao.getData(), transacao.getValor(),
				conta.getNumeroAgencia(), conta.getDigitoAgencia(),
				conta.getNumero(), conta.getDigito()
				);
		} catch (Exception ex) {
			System.out.println("Erro na transacao de saque na conta: " + ex.getMessage());
		}
	}
}
