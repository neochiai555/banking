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
@Table(name = "movimentacao_cartao", schema = "banking")
@JsonIgnoreProperties({"cartao","tipoMovimentacaoCartao"})
public class MovimentacaoCartao implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5529346645941197666L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banking.seq_movimentacao_conta")
	@SequenceGenerator(name = "banking.seq_movimentacao_conta", allocationSize = 1)
	private int id;
	
	@Column(name = "data",  nullable = false)
	private Date data;
	
	@Column(name = "valor",  nullable = false)
	private BigDecimal valor;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Cartao.class)
	@JoinColumn(name = "id_cartao")
	private Cartao cartao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo")
	private TipoMovimentacaoCartao tipoMovimentacaoCartao;	
	
	@Transient
	private String numeroCartao;
	
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

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public TipoMovimentacaoCartao getTipoMovimentacaoCartao() {
		return tipoMovimentacaoCartao;
	}

	public void setTipoMovimentacaoCartao(TipoMovimentacaoCartao tipoMovimentacaoCartao) {
		this.tipoMovimentacaoCartao = tipoMovimentacaoCartao;
	}

	public String getNumeroCartao() {
		return cartao.getNumero();
	}

	public String getCodigoTipoMovimentacao() {
		return tipoMovimentacaoCartao.getCodigo();
	}
	
}
