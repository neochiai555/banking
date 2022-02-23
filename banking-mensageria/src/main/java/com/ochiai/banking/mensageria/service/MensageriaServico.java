package com.ochiai.banking.mensageria.service;

public interface MensageriaServico {

	String TOPICO_INVOCACAO_TRANSACAO_CARTAO = "banking_card_transaction_invocation";
	String TOPICO_RETORNO_TRANSACAO_CARTAO = "banking_card_transaction_return";
	String TOPICO_INVOCACAO_TRANSACAO_CONTA = "banking_account_transaction_invocation";
	String TOPICO_RETORNO_TRANSACAO_CONTA = "banking_account_transaction_return";
	String GRUPO_INVOCACAO_TRANSACAO_CARTAO = "banking_card_transaction_invocation_group";
	String GRUPO_RETORNO_TRANSACAO_CARTAO = "banking_card_transaction_return_group";
	String GRUPO_INVOCACAO_TRANSACAO_CONTA = "banking_account_transaction_invocation_group";
	String GRUPO_RETORNO_TRANSACAO_CONTA = "banking_account_transaction_return_group";

	void enviar(String topico, String chave, String mensagem);

	void receber(String mensagem);

}