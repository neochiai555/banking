package com.ochiai.banking.core.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ochiai.banking.core.persistence.entity.TipoMovimentacao;

@Repository
public interface TipoMovimentacaoRepositorio extends JpaRepository<TipoMovimentacao, Integer>, JpaSpecificationExecutor<TipoMovimentacao>, PagingAndSortingRepository<TipoMovimentacao, Integer> {
	
	@Query("select tm from TipoMovimentacao tm where tm.id = ?1")
	Optional<TipoMovimentacao> findById(Integer id);

	@Query("select tm from TipoMovimentacao tm where tm.codigo = ?1")
	Optional<TipoMovimentacao> findByCodigo(String codigo);
}