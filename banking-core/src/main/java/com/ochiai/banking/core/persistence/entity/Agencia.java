package com.ochiai.banking.core.persistence.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "agencia", schema = "banking")
public class Agencia implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2140703615501711956L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banking.seq_agencia")
	@SequenceGenerator(name = "banking.seq_agencia", allocationSize = 1)
	private int id;
	
	@Column(name = "nome",  nullable = false)
	private String nome;
	
	@Column(name = "numero",  nullable = false)
	private String numero;
	
	@Column(name = "digito",  nullable = false)
	private String digito;
	
	@OneToMany(mappedBy = "agencia")
	private Set<Conta> contas;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDigito() {
		return digito;
	}

	public void setDigito(String digito) {
		this.digito = digito;
	}

	public Set<Conta> getContas() {
		return contas;
	}

	public void setContas(Set<Conta> contas) {
		this.contas = contas;
	}	
	
}
