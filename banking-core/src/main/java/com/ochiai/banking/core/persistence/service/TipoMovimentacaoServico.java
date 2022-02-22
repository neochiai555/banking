package com.ochiai.banking.core.persistence.service;

import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.TipoMovimentacao;

@Service
public interface TipoMovimentacaoServico {
	TipoMovimentacao findById(Integer id);
	
	TipoMovimentacao findByCodigo(String codigo);
}
