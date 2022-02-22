package com.ochiai.banking.core.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ochiai.banking.core.persistence.entity.TipoMovimentacaoConta;

@Repository
public interface TipoMovimentacaoContaRepositorio extends JpaRepository<TipoMovimentacaoConta, Integer>, JpaSpecificationExecutor<TipoMovimentacaoConta>, PagingAndSortingRepository<TipoMovimentacaoConta, Integer> {
	
	@Query("select tm from TipoMovimentacaoConta tm where tm.id = ?1")
	Optional<TipoMovimentacaoConta> findById(Integer id);

	@Query("select tm from TipoMovimentacaoConta tm where tm.codigo = ?1")
	Optional<TipoMovimentacaoConta> findByCodigo(String codigo);
}