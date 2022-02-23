package com.ochiai.banking.mensageria.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoCartao {
	private String numeroCartao;
	
	private String tipo;
	private Date data;
	private BigDecimal valor;
	private String descricao;
	
	private Boolean sucesso;
	private String retorno;
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getIdentificadorCartao() {
		return numeroCartao;
	}
	public Boolean getSucesso() {
		return sucesso;
	}
	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}
	public String getRetorno() {
		return retorno;
	}
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

}
