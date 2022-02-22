package com.ochiai.banking.conteudo.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.ochiai.banking.conteudo.exception.ConteudoException;
import com.ochiai.banking.conteudo.persistence.entity.Campanha;

@Component
public class CampanhaRepositorioCustomImpl implements CampanhaRepositorioCustom {
	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired 
	private CampanhaRepositorio campanhaRepositorio;
	
	@Override
	public void inserir(String nome, String tipo, String descricao) throws ConteudoException {
		Campanha  campanha = new Campanha(nome, tipo, descricao);
		
		campanhaRepositorio.save(campanha);
		
		if(campanha.getId() == null) {
			throw new ConteudoException("Erro ao criar campanha");
		}
	}

}
