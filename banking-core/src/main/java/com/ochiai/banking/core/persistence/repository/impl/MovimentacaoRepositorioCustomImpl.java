package com.ochiai.banking.core.persistence.repository.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ochiai.banking.core.exception.ContaDuplicadaException;
import com.ochiai.banking.core.exception.ContaNaoEncontradaException;
import com.ochiai.banking.core.exception.SaldoInsuficienteException;
import com.ochiai.banking.core.persistence.entity.Conta;
import com.ochiai.banking.core.persistence.entity.Movimentacao;
import com.ochiai.banking.core.persistence.entity.TipoMovimentacao;
import com.ochiai.banking.core.persistence.repository.ContaRepositorio;
import com.ochiai.banking.core.persistence.repository.MovimentacaoRepositorio;
import com.ochiai.banking.core.persistence.repository.MovimentacaoRepositorioCustom;
import com.ochiai.banking.core.persistence.repository.TipoMovimentacaoRepositorio;

@Component
public class MovimentacaoRepositorioCustomImpl implements MovimentacaoRepositorioCustom {
	@Autowired
	private MovimentacaoRepositorio movimentacaoRepositorio;
	
	@Autowired
	private ContaRepositorio contaRepositorio;

	@Autowired
	private TipoMovimentacaoRepositorio tipoMovimentacaoRepositorio;

	@Override
	@Transactional
	public Movimentacao deposito(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws Exception {
		List<Conta> contas = contaRepositorio.findByNumeroDigitoAgenciaConta(numeroAgencia, digitoAgencia, numeroConta, digitoConta);
		
		if (contas == null || contas.isEmpty()) {
			throw new Exception("Conta não encontrada");
		}
		if (contas.size() > 1) {
			throw new Exception("Conta duplicada");
		}
		
		Conta conta = contas.get(0);

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(data);
		movimentacao.setValor(valor);
		movimentacao.setTipoMovimentacao(tipoMovimentacaoRepositorio.findByCodigo(TipoMovimentacao.TIPO_DEPOSITO).orElse(null));
		
		movimentacaoRepositorio.save(movimentacao);

		conta.setSaldoAtual(conta.getSaldoAtual().add(valor));
		contaRepositorio.save(conta);		
		
		return movimentacao;
	}

	@Override
	@Transactional
	public Movimentacao saque(Date data, BigDecimal valor, String numeroAgencia, String digitoAgencia, String numeroConta, String digitoConta) throws SaldoInsuficienteException, ContaDuplicadaException, ContaNaoEncontradaException {
		List<Conta> contas = contaRepositorio.findByNumeroDigitoAgenciaConta(numeroAgencia, digitoAgencia, numeroConta, digitoConta);
		
		if (contas == null || contas.isEmpty()) {
			throw new ContaNaoEncontradaException("Conta não encontrada");
		}
		if (contas.size() > 1) {
			throw new ContaDuplicadaException("Conta duplicada");
		}
		
		Conta conta = contas.get(0);

		if (conta.getSaldoAtual().subtract(valor).signum() < 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
		movimentacao.setData(data);
		movimentacao.setValor(valor);
		movimentacao.setTipoMovimentacao(tipoMovimentacaoRepositorio.findByCodigo(TipoMovimentacao.TIPO_SAQUE).orElse(null));
		
		movimentacaoRepositorio.save(movimentacao);

		conta.setSaldoAtual(conta.getSaldoAtual().subtract(valor));
		contaRepositorio.save(conta);		

		return movimentacao;
	} 

}