package com.ochiai.banking.core.persistence.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.MovimentacaoCartao;
import com.ochiai.banking.core.persistence.repository.MovimentacaoCartaoRepositorio;
import com.ochiai.banking.core.persistence.repository.MovimentacaoCartaoRepositorioCustom;
import com.ochiai.banking.core.persistence.service.MovimentacaoCartaoServico;

@Service
public class MovimentacaoCartaoServicoImpl implements MovimentacaoCartaoServico {
	@Autowired
	private MovimentacaoCartaoRepositorio movimentacaoCartaoRepositorio;

	@Autowired
	private MovimentacaoCartaoRepositorioCustom movimentacaoCartaoRepositorioCustom;
	
	public List<MovimentacaoCartao> findByIdCartao(Integer id) {
		return movimentacaoCartaoRepositorio.findByIdCartao(id);
	}
	
	public List<MovimentacaoCartao> findByNumeroCartao(String numeroCartao) {
		return movimentacaoCartaoRepositorio.findByNumeroCartao(numeroCartao);
	}
	
	public MovimentacaoCartao pagamento(Date data, BigDecimal valor, String numeroCartao) throws Exception {
		return movimentacaoCartaoRepositorioCustom.pagamento(data, valor, numeroCartao);
	}
	
	public MovimentacaoCartao compra(Date data, BigDecimal valor, String numeroCartao) throws Exception {
		return movimentacaoCartaoRepositorioCustom.compra(data, valor, numeroCartao);	
	}
	
	public MovimentacaoCartao estorno(Date data, BigDecimal valor, String numeroCartao) throws Exception {
		return movimentacaoCartaoRepositorioCustom.estorno(data, valor, numeroCartao);	
	}
}
