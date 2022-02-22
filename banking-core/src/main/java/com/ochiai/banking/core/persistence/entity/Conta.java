package com.ochiai.banking.core.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "conta", schema = "banking")
@JsonIgnoreProperties({"agencia"})
public class Conta implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5632837047601755093L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banking.seq_conta")
	@SequenceGenerator(name = "banking.seq_conta", allocationSize = 1)
	private int id;
	
	@Column(name = "numero",  nullable = false)
	private String numero;
	
	@Column(name = "digito",  nullable = false)
	private String digito;	
	
	@Column(name = "tipo",  nullable = false)
	private String tipo;	

	@Column(name = "titular",  nullable = false)
	private String titular;	

	@Column(name = "saldo_inicial",  nullable = false)
	private BigDecimal saldoInicial;
	
	@Column(name = "saldo_atual",  nullable = false)
	private BigDecimal saldoAtual;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_agencia")
	private Agencia agencia;

	@OneToMany(mappedBy = "conta", fetch = FetchType.LAZY)
	private Set<Movimentacao> movimentacoes;
	
	@Transient
	private String numeroAgencia;

	@Transient
	private String digitoAgencia;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public BigDecimal getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(BigDecimal saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public BigDecimal getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(BigDecimal saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public Set<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	public void setMovimentacoes(Set<Movimentacao> movimentacoes) {
		this.movimentacoes = movimentacoes;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String getNumeroAgencia() {
		return agencia.getNumero();
	}

	public String getDigitoAgencia() {
		return agencia.getDigito();
	}

}
