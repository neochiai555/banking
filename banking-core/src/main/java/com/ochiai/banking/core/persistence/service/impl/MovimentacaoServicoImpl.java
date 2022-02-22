package com.ochiai.banking.core.persistence.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.Movimentacao;
import com.ochiai.banking.core.persistence.repository.MovimentacaoRepositorio;
import com.ochiai.banking.core.persistence.repository.MovimentacaoRepositorioCustom;
import com.ochiai.banking.core.persistence.service.MovimentacaoServico;

@Service
public class MovimentacaoServicoImpl implements MovimentacaoServico {
	@Autowired
	private MovimentacaoRepositorio movimentacaoRepositorio;

	@Autowired
	private MovimentacaoRepositorioCustom movimentacaoRepositorioCustom;
	
	public List<Movimentacao> findByIdConta(Integer id) {
		return movimentacaoRepositorio.findByIdConta(id);
	}
	
	public List<Movimentacao> findByNumeroDigitoConta(String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) {
		return movimentacaoRepositorio.findByNumeroDigitoConta(numeroAgencia, digitoAgencia, numeroConta, digitoConta);
	}
	
	public Movimentacao deposito(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception {
		return movimentacaoRepositorioCustom.deposito(data, valor, numeroAgencia, digitoAgencia, numeroConta, digitoConta);
	}
	
	public Movimentacao saque(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception {
		return movimentacaoRepositorioCustom.saque(data, valor, numeroAgencia, digitoAgencia, numeroConta, digitoConta);	
	}
}
