package com.ochiai.banking.mensageria.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoCartao extends Transacao {
	private String numeroCartao;
	
	private String tipo;
	private Date data;
	private BigDecimal valor;
	private String descricao;
	
	private Boolean processada;
	private String retorno;
	
	public TransacaoCartao() {	
		super();
	}

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
	public Boolean getProcessada() {
		return processada;
	}
	public void setProcessada(Boolean processada) {
		this.processada = processada;
	}
	public String getRetorno() {
		return retorno;
	}
	public void setRetorno(String retorno) {
		this.retorno = retorno;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("{")
			.append("uuid:").append(uuid)
			.append("numeroCartao:").append(numeroCartao)
			.append("tipo:").append(tipo)
			.append("data:").append(data)
			.append("valor:").append(valor)
			.append("descricao:").append(descricao)
			.append("processada:").append(processada)
			.append("retorno:").append(retorno)
			.append("}");
		
		return sb.toString();
	}
}
