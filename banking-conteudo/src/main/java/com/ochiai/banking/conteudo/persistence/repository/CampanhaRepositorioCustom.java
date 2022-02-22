package com.ochiai.banking.conteudo.persistence.repository;

import com.ochiai.banking.conteudo.exception.ConteudoException;

public interface CampanhaRepositorioCustom {
	void inserir(String nome, String tipo, String descricao) throws ConteudoException;
}
