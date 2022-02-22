package com.ochiai.banking.core.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ochiai.banking.core.persistence.entity.Cartao;

@Repository
public interface CartaoRepositorio extends JpaRepository<Cartao, Integer>, JpaSpecificationExecutor<Cartao>, PagingAndSortingRepository<Cartao, Integer> {
	
	@Query("select c from Cartao c where c.id = ?1")
	Optional<Cartao> findById(Integer id);

	@Query("select c from Cartao c where c.numero = ?1")
	List<Cartao> findByNumero(String numeroCartao);
	
	@Query("select c from Conta c where c.titular like %?1%")
	List<Cartao> findByTitular(String titular);
}