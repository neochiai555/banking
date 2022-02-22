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
@Table(name = "cartao", schema = "banking")
@JsonIgnoreProperties({"tipoCartao"})
public class Cartao implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5529346645941197666L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banking.seq_cartao")
	@SequenceGenerator(name = "banking.seq_cartao", allocationSize = 1)
	private int id;
	
	@Column(name = "emissao",  nullable = false)
	private Date emissao;

	@Column(name = "validade",  nullable = false)
	private Date validade;

	@Column(name = "numero",  nullable = false)
	private String numero;

	@Column(name = "limite_saque",  nullable = false)
	private BigDecimal limiteSaque;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo")
	private TipoCartao tipoCartao;	
	
	@Transient
	private String codigoTipoCartao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEmissao() {
		return emissao;
	}

	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getLimiteSaque() {
		return limiteSaque;
	}

	public void setLimiteSaque(BigDecimal limiteSaque) {
		this.limiteSaque = limiteSaque;
	}

	public TipoCartao getTipoCartao() {
		return tipoCartao;
	}

	public void setTipoCartao(TipoCartao tipoCartao) {
		this.tipoCartao = tipoCartao;
	}

	public String getCodigoTipoCartao() {
		return tipoCartao.getCodigo();
	}
	
}
