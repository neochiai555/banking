package com.ochiai.banking.core.persistence.service;

import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.TipoMovimentacaoConta;

@Service
public interface TipoMovimentacaoContaServico {
	TipoMovimentacaoConta findById(Integer id);
	
	TipoMovimentacaoConta findByCodigo(String codigo);
}
