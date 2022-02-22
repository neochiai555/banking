package com.ochiai.banking.core.persistence.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ochiai.banking.core.persistence.entity.MovimentacaoCartao;

@Service
public interface MovimentacaoCartaoServico {
	List<MovimentacaoCartao> findByIdCartao(Integer id);
	
	List<MovimentacaoCartao> findByNumeroCartao(String numeroCartao);
	
	MovimentacaoCartao pagamento(Date data, BigDecimal valor, String numeroCartao) throws Exception;
	
	MovimentacaoCartao compra(Date data, BigDecimal valor, String numeroCartao) throws Exception;
	
	MovimentacaoCartao estorno(Date data, BigDecimal valor, String numeroCartao) throws Exception;
}
