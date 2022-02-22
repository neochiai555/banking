package com.ochiai.banking.conteudo.persistence.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ochiai.banking.conteudo.persistence.entity.Campanha;

public interface CampanhaRepositorio extends MongoRepository<Campanha, String> {
    
    @Query("{nome:'?0'}")
    Campanha findByNome(String nome);
    
    @Query(value="{tipo:'?0'}", fields="{'nome' : 1, 'tipo' : 1, 'descricao' : 1}")
    List<Campanha> findAll(String tipo);
    
    public long count();

}