package com.ochiai.banking.core.persistence.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.MovimentacaoConta;

@Service
public interface MovimentacaoContaServico {
	List<MovimentacaoConta> findByIdConta(Integer id);
	
	List<MovimentacaoConta> findByNumeroDigitoConta(String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta);
	
	MovimentacaoConta deposito(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception;
	
	MovimentacaoConta saque(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception;
}
