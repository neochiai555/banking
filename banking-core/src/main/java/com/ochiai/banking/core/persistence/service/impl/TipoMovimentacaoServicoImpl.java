package com.ochiai.banking.core.persistence.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.TipoMovimentacao;
import com.ochiai.banking.core.persistence.repository.TipoMovimentacaoRepositorio;
import com.ochiai.banking.core.persistence.service.TipoMovimentacaoServico;

@Service
public class TipoMovimentacaoServicoImpl implements TipoMovimentacaoServico {
	@Autowired
	private TipoMovimentacaoRepositorio tipoMovimentacaoRepositorio;
	
	public TipoMovimentacao findById(Integer id) {
		return tipoMovimentacaoRepositorio.findById(id).orElse(null);
	}
	
	public TipoMovimentacao findByCodigo(String codigo) {
		return tipoMovimentacaoRepositorio.findByCodigo(codigo).orElse(null);
	}
}
