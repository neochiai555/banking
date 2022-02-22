package com.ochiai.banking.core.persistence.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.MovimentacaoConta;
import com.ochiai.banking.core.persistence.repository.MovimentacaoContaRepositorio;
import com.ochiai.banking.core.persistence.repository.MovimentacaoContaRepositorioCustom;
import com.ochiai.banking.core.persistence.service.MovimentacaoContaServico;

@Service
public class MovimentacaoContaServicoImpl implements MovimentacaoContaServico {
	@Autowired
	private MovimentacaoContaRepositorio movimentacaoRepositorio;

	@Autowired
	private MovimentacaoContaRepositorioCustom movimentacaoRepositorioCustom;
	
	public List<MovimentacaoConta> findByIdConta(Integer id) {
		return movimentacaoRepositorio.findByIdConta(id);
	}
	
	public List<MovimentacaoConta> findByNumeroDigitoConta(String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) {
		return movimentacaoRepositorio.findByNumeroDigitoConta(numeroAgencia, digitoAgencia, numeroConta, digitoConta);
	}
	
	public MovimentacaoConta deposito(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception {
		return movimentacaoRepositorioCustom.deposito(data, valor, numeroAgencia, digitoAgencia, numeroConta, digitoConta);
	}
	
	public MovimentacaoConta saque(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception {
		return movimentacaoRepositorioCustom.saque(data, valor, numeroAgencia, digitoAgencia, numeroConta, digitoConta);	
	}
}
