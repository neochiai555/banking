package com.ochiai.banking.core.persistence.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "movimentacao", schema = "banking")
@JsonIgnoreProperties({"conta","tipoMovimentacao"})
public class Movimentacao implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5529346645941197666L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banking.seq_movimentacao")
	@SequenceGenerator(name = "banking.seq_movimentacao", allocationSize = 1)
	private int id;
	
	@Column(name = "data",  nullable = false)
	private Date data;
	
	@Column(name = "valor",  nullable = false)
	private BigDecimal valor;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Conta.class)
	@JoinColumn(name = "id_conta")
	private Conta conta;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo")
	private TipoMovimentacao tipoMovimentacao;	
	
	@Transient
	private String numeroConta;
	
	@Transient
	private String digitoConta;

	@Transient
	private String codigoTipoMovimentacao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public String getNumeroConta() {
		return conta.getNumero();
	}

	public String getDigitoConta() {
		return conta.getDigito();
	}

	public String getCodigoTipoMovimentacao() {
		return tipoMovimentacao.getCodigo();
	}
	
}
