package com.ochiai.banking.core.persistence.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.Cartao;

@Service
public interface CartaoServico {
	Cartao findById(Integer id);
	
	List<Cartao> findByNumeroCartao(String numeroCartao);
}
