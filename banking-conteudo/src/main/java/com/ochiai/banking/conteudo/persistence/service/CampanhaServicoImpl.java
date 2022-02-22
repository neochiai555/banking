package com.ochiai.banking.conteudo.persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochiai.banking.conteudo.persistence.entity.Campanha;
import com.ochiai.banking.conteudo.persistence.repository.CampanhaRepositorio;

@Service
public class CampanhaServicoImpl implements CampanhaServico {

	@Autowired
	private CampanhaRepositorio campanhaRepositorio;
	
	public Campanha findByNome(String nome) {
		return campanhaRepositorio.findByNome(nome);
	}

	public List<Campanha> findAll(String tipo) {
		return campanhaRepositorio.findAll(tipo);
	}

	public List<Campanha> findAll() {
		return campanhaRepositorio.findAll();
	}

	public Campanha criar(String nome, String tipo, String descricao) {
		Campanha campanha = new Campanha(nome, tipo, descricao);
		return campanhaRepositorio.save(campanha);
	}

}
