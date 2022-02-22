package com.ochiai.banking.core.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.TipoMovimentacaoCartao;
import com.ochiai.banking.core.persistence.repository.TipoMovimentacaoCartaoRepositorio;
import com.ochiai.banking.core.persistence.service.TipoMovimentacaoCartaoServico;

@Service
public class TipoMovimentacaoCartaoServicoImpl implements TipoMovimentacaoCartaoServico {
	@Autowired
	private TipoMovimentacaoCartaoRepositorio tipoMovimentacaoCartaoRepositorio;
	
	public TipoMovimentacaoCartao findById(Integer id) {
		return tipoMovimentacaoCartaoRepositorio.findById(id).orElse(null);
	}
	
	public TipoMovimentacaoCartao findByCodigo(String codigo) {
		return tipoMovimentacaoCartaoRepositorio.findByCodigo(codigo).orElse(null);
	}
}
