package com.ochiai.banking.core.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ochiai.banking.core.persistence.entity.Conta;

@Repository
public interface ContaRepositorio extends JpaRepository<Conta, Integer>, JpaSpecificationExecutor<Conta>, PagingAndSortingRepository<Conta, Integer> {
	
	@Query("select c from Conta c where c.id = ?1")
	Optional<Conta> findById(Integer id);

	@Query("select c from Conta c where c.agencia.numero = ?1 and c.agencia.digito = ?2 and c.numero = ?3 and c.digito = ?4")
	List<Conta> findByNumeroDigitoAgenciaConta(String numeroAgencia,  String digitoAgencia, String numeroConta, String digitoConta);
	
	@Query("select c from Conta c where c.agencia.id = ?1")
	List<Conta> findByIdAgencia(Integer idAgencia);

	@Query("select c from Conta c where c.agencia.numero = ?1 and c.agencia.digito = ?2")
	List<Conta> findByNumeroDigitoAgencia(String numero, String digito);

	@Query("select c from Conta c where c.titular like %?1%")
	List<Conta> findByTitular(String titular);
}