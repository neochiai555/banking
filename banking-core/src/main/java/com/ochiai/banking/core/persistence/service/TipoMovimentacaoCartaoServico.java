package com.ochiai.banking.core.persistence.service;

import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.TipoMovimentacaoCartao;

@Service
public interface TipoMovimentacaoCartaoServico {
	TipoMovimentacaoCartao findById(Integer id);
	
	TipoMovimentacaoCartao findByCodigo(String codigo);
}
