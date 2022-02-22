package com.ochiai.banking.core.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ochiai.banking.core.persistence.entity.TipoMovimentacaoCartao;

@Repository
public interface TipoMovimentacaoCartaoRepositorio extends JpaRepository<TipoMovimentacaoCartao, Integer>, JpaSpecificationExecutor<TipoMovimentacaoCartao>, PagingAndSortingRepository<TipoMovimentacaoCartao, Integer> {
	
	@Query("select tm from TipoMovimentacaoCartao tm where tm.id = ?1")
	Optional<TipoMovimentacaoCartao> findById(Integer id);

	@Query("select tm from TipoMovimentacaoCartao tm where tm.codigo = ?1")
	Optional<TipoMovimentacaoCartao> findByCodigo(String codigo);
}