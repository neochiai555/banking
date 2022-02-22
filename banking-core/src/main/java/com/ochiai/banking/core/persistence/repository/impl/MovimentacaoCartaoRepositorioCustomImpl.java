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
import com.ochiai.banking.core.persistence.entity.Cartao;
import com.ochiai.banking.core.persistence.entity.MovimentacaoCartao;
import com.ochiai.banking.core.persistence.entity.TipoMovimentacaoCartao;
import com.ochiai.banking.core.persistence.repository.CartaoRepositorio;
import com.ochiai.banking.core.persistence.repository.MovimentacaoCartaoRepositorio;
import com.ochiai.banking.core.persistence.repository.MovimentacaoCartaoRepositorioCustom;
import com.ochiai.banking.core.persistence.repository.TipoMovimentacaoCartaoRepositorio;

@Component
public class MovimentacaoCartaoRepositorioCustomImpl implements MovimentacaoCartaoRepositorioCustom {
	@Autowired
	private MovimentacaoCartaoRepositorio movimentacaoRepositorio;
	
	@Autowired
	private CartaoRepositorio cartaoRepositorio;

	@Autowired
	private TipoMovimentacaoCartaoRepositorio tipoMovimentacaoCartaoRepositorio;

	@Override
	@Transactional
	public MovimentacaoCartao pagamento(Date data, BigDecimal valor, String numeroCartao) throws Exception {
		List<Cartao> cartoes = cartaoRepositorio.findByNumero(numeroCartao);
		
		if (cartoes == null || cartoes.isEmpty()) {
			throw new Exception("Cartão não encontrado");
		}
		if (cartoes.size() > 1) {
			throw new Exception("Cartão duplicado");
		}
		
		Cartao cartao = cartoes.get(0);

		MovimentacaoCartao movimentacao = new MovimentacaoCartao();
		movimentacao.setCartao(cartao);
		movimentacao.setData(data);
		movimentacao.setValor(valor);
		movimentacao.setTipoMovimentacaoCartao(tipoMovimentacaoCartaoRepositorio.findByCodigo(TipoMovimentacaoCartao.TIPO_PAGAMENTO).orElse(null));
		
		movimentacaoRepositorio.save(movimentacao);
		
		return movimentacao;
	}

	@Override
	@Transactional
	public MovimentacaoCartao compra(Date data, BigDecimal valor, String numeroCartao) throws SaldoInsuficienteException, ContaDuplicadaException, ContaNaoEncontradaException {
		List<Cartao> cartoes = cartaoRepositorio.findByNumero(numeroCartao);
		
		if (cartoes == null || cartoes.isEmpty()) {
			throw new ContaNaoEncontradaException("Cartão não encontrado");
		}
		if (cartoes.size() > 1) {
			throw new ContaDuplicadaException("Cartão duplicado");
		}
		
		Cartao cartao = cartoes.get(0);

		if (cartao.getLimiteSaque().subtract(valor).signum() < 0) {
			throw new SaldoInsuficienteException("Saldo insuficiente");
		}
		
		MovimentacaoCartao movimentacao = new MovimentacaoCartao();
		movimentacao.setCartao(cartao);
		movimentacao.setData(data);
		movimentacao.setValor(valor);
		movimentacao.setTipoMovimentacaoCartao(tipoMovimentacaoCartaoRepositorio.findByCodigo(TipoMovimentacaoCartao.TIPO_COMPRA).orElse(null));
		
		movimentacaoRepositorio.save(movimentacao);

		return movimentacao;
	} 

	@Override
	@Transactional
	public MovimentacaoCartao estorno(Date data, BigDecimal valor, String numeroCartao) throws SaldoInsuficienteException, ContaDuplicadaException, ContaNaoEncontradaException {
		List<Cartao> cartoes = cartaoRepositorio.findByNumero(numeroCartao);
		
		if (cartoes == null || cartoes.isEmpty()) {
			throw new ContaNaoEncontradaException("Cartão não encontrado");
		}
		if (cartoes.size() > 1) {
			throw new ContaDuplicadaException("Cartão duplicado");
		}
		
		Cartao cartao = cartoes.get(0);

		MovimentacaoCartao movimentacao = new MovimentacaoCartao();
		movimentacao.setCartao(cartao);
		movimentacao.setData(data);
		movimentacao.setValor(valor);
		movimentacao.setTipoMovimentacaoCartao(tipoMovimentacaoCartaoRepositorio.findByCodigo(TipoMovimentacaoCartao.TIPO_ESTORNO).orElse(null));
		
		movimentacaoRepositorio.save(movimentacao);

		return movimentacao;
	}

}