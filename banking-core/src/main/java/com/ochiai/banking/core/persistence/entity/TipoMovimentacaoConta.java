package com.ochiai.banking.core.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_movimentacao_conta", schema = "banking")
public class TipoMovimentacaoConta implements Serializable {

	public static final String TIPO_DEPOSITO = "DEP";
	public static final String TIPO_SAQUE = "SAQ";
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 987472252150115929L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banking.seq_tipo_movimentacao_conta")
	@SequenceGenerator(name = "banking.seq_tipo_movimentacao_conta", allocationSize = 1)
	private int id;
	
	@Column(name = "codigo",  nullable = false)
	private String codigo;
	
	@Column(name = "descricao",  nullable = false)
	private String descricao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
