package com.ochiai.banking.core.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ochiai.banking.core.persistence.entity.Agencia;

@Repository
public interface AgenciaRepositorio extends JpaRepository<Agencia, Integer>, JpaSpecificationExecutor<Agencia>, PagingAndSortingRepository<Agencia, Integer> {
	
	@Query("select a from Agencia a where a.id = ?1")
	Optional<Agencia> findById(Integer id);

	@Query("select a from Agencia a where a.numero = ?1 and a.digito = ?2")
	List<Agencia> findByNumeroDigito(String numero,  String digito);
	
	@Query("select a from Agencia a where a.nome like %?1%")
	List<Agencia> findByNome(String nome);
}