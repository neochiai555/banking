package com.ochiai.banking.core.persistence.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.Conta;
import com.ochiai.banking.core.persistence.repository.ContaRepositorio;
import com.ochiai.banking.core.persistence.service.ContaServico;

@Service
public class ContaServicoImpl implements ContaServico {
	@Autowired
	private ContaRepositorio contaRepositorio;
	
	public Conta findById(Integer id) {
		return contaRepositorio.findById(id).orElse(null);
	}
	
	public List<Conta> findByNumeroDigitoAgenciaConta(String numeroAgencia,  String digitoAgencia, String numeroConta, String digitoConta) {
		return contaRepositorio.findByNumeroDigitoAgenciaConta(numeroAgencia, digitoAgencia, numeroConta, digitoConta);
	}
	
	public List<Conta> findByIdAgencia(Integer idAgencia) {
		return contaRepositorio.findByIdAgencia(idAgencia);
	}
	
	public List<Conta> findByNumeroDigitoAgencia(String numero, String digito) {
		return contaRepositorio.findByNumeroDigitoAgencia(numero, digito);
	}
	
	public List<Conta> findByTitular(String titular) {
		return contaRepositorio.findByTitular(titular);
	}
}
