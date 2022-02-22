package com.ochiai.banking.core.persistence.repository;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.ochiai.banking.core.persistence.entity.Movimentacao;

@Component
public interface MovimentacaoRepositorioCustom  {
	Movimentacao deposito(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception;
	
	Movimentacao saque(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception;
}