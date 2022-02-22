package com.ochiai.banking.core.persistence.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.Conta;

@Service
public interface ContaServico {
	Conta findById(Integer id);
	
	List<Conta> findByNumeroDigitoAgenciaConta(String numeroAgencia,  String digitoAgencia, String numeroConta, String digitoConta);
	
	List<Conta> findByIdAgencia(Integer idAgencia);
	
	List<Conta> findByNumeroDigitoAgencia(String numero, String digito);
	
	List<Conta> findByTitular(String titular);
}
