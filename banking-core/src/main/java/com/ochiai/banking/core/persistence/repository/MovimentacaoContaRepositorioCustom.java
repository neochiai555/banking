package com.ochiai.banking.core.persistence.repository;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.ochiai.banking.core.persistence.entity.MovimentacaoConta;

@Component
public interface MovimentacaoContaRepositorioCustom  {
	MovimentacaoConta deposito(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception;
	
	MovimentacaoConta saque(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception;
}