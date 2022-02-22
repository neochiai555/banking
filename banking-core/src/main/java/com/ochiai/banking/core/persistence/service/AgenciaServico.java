package com.ochiai.banking.core.persistence.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.Agencia;

@Service
public interface AgenciaServico {
	Agencia findById(Integer id);
	
	List<Agencia> findByNumeroDigito(String numero,  String digito);
	
	List<Agencia> findByNome(String nome);
}
