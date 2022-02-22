package com.ochiai.banking.core.persistence.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.Movimentacao;

@Service
public interface MovimentacaoServico {
	List<Movimentacao> findByIdConta(Integer id);
	
	List<Movimentacao> findByNumeroDigitoConta(String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta);
	
	Movimentacao deposito(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception;
	
	Movimentacao saque(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception;
}
