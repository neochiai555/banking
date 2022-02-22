package com.ochiai.banking.core.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ochiai.banking.core.persistence.entity.MovimentacaoConta;

@Repository
public interface MovimentacaoContaRepositorio extends JpaRepository<MovimentacaoConta, Integer> {
	
	@Query("select m from MovimentacaoConta m where m.conta.id = ?1 order by m.data")
	List<MovimentacaoConta> findByIdConta(Integer id);
	
	@Query("select m from MovimentacaoConta m where m.conta.agencia.numero = ?1 and m.conta.agencia.digito = ?2 and m.conta.numero = ?3 and m.conta.digito = ?4 order by m.data")
	List<MovimentacaoConta> findByNumeroDigitoConta(String numeroAgencia, String digitoAgencia, 
			String numeroConta, String digitoConta);
	
}