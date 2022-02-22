package com.ochiai.banking.core.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.Agencia;
import com.ochiai.banking.core.persistence.repository.AgenciaRepositorio;
import com.ochiai.banking.core.persistence.service.AgenciaServico;

@Service
public class AgenciaServicoImpl implements AgenciaServico {
	@Autowired
	private AgenciaRepositorio agenciaRepositorio;
	
	public Agencia findById(Integer id) {
		return agenciaRepositorio.findById(id).orElse(null);
	}
	
	public List<Agencia> findByNumeroDigito(String numero,  String digito) {
		return agenciaRepositorio.findByNumeroDigito(numero, digito);
	}
	
	public List<Agencia> findByNome(String nome) {
		return findByNome(nome);
	}
}
