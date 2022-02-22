package com.ochiai.banking.core.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.TipoMovimentacaoConta;
import com.ochiai.banking.core.persistence.repository.TipoMovimentacaoContaRepositorio;
import com.ochiai.banking.core.persistence.service.TipoMovimentacaoContaServico;

@Service
public class TipoMovimentacaoContaServicoImpl implements TipoMovimentacaoContaServico {
	@Autowired
	private TipoMovimentacaoContaRepositorio tipoMovimentacaoContaRepositorio;
	
	public TipoMovimentacaoConta findById(Integer id) {
		return tipoMovimentacaoContaRepositorio.findById(id).orElse(null);
	}
	
	public TipoMovimentacaoConta findByCodigo(String codigo) {
		return tipoMovimentacaoContaRepositorio.findByCodigo(codigo).orElse(null);
	}
}
