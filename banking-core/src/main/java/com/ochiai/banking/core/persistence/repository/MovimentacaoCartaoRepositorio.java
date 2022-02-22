package com.ochiai.banking.core.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ochiai.banking.core.persistence.entity.MovimentacaoCartao;

@Repository
public interface MovimentacaoCartaoRepositorio extends JpaRepository<MovimentacaoCartao, Integer> {
	
	@Query("select m from MovimentacaoCartao m where m.cartao.id = ?1 order by m.data")
	List<MovimentacaoCartao> findByIdCartao(Integer id);
	
	@Query("select m from MovimentacaoCartao m where m.cartao.numero = ?1 order by m.data")
	List<MovimentacaoCartao> findByNumeroCartao(String numeroCartao);
	
}