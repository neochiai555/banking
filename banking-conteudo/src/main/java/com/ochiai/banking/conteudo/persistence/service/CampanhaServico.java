package com.ochiai.banking.conteudo.persistence.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ochiai.banking.conteudo.persistence.entity.Campanha;

@Service
public interface CampanhaServico {
	Campanha findByNome(String nome);
	
	List<Campanha> findAll(String tipo);
	
	List<Campanha> findAll();
	
	Campanha criar(String nome, String tipo, String descricao);
}
