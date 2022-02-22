package com.ochiai.banking.core.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.Cartao;
import com.ochiai.banking.core.persistence.repository.CartaoRepositorio;
import com.ochiai.banking.core.persistence.service.CartaoServico;

@Service
public class CartaoServicoImpl implements CartaoServico {
	@Autowired
	private CartaoRepositorio cartaoRepositorio;
	
	public Cartao findById(Integer id) {
		return cartaoRepositorio.findById(id).orElse(null);
	}
	
	public List<Cartao> findByNumeroCartao(String numeroCartao) {
		return cartaoRepositorio.findByNumero(numeroCartao);
	}
}
