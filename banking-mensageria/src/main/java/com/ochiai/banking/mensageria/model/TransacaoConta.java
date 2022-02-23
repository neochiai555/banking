package com.ochiai.banking.mensageria.model;

import java.math.BigDecimal;
import java.util.Date;

public class TransacaoConta {
	private String numeroAgencia;
	private String digitoAgencia;
	private String numeroConta;
	private String digitoConta;
	
	private String tipo;
	private Date data;
	private BigDecimal valor;
	private String descricao;
	
	private Boolean processada;
	private String retorno;
	
	public String getNumeroAgencia() {
		return numeroAgencia;
	}
	public void setNumeroAgencia(String numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	public String getDigitoAgencia() {
		return digitoAgencia;
	}
	public void setDigitoAgencia(String digitoAgencia) {
		this.digitoAgencia = digitoAgencia;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public String getDigitoConta() {
		return digitoConta;
	}
	public void setDigitoConta(String digitoConta) {
		this.digitoConta = digitoConta;
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
	public String getIdentificadorConta() {
		return numeroAgencia + digitoAgencia + numeroConta + digitoConta;
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

}
