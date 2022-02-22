package com.ochiai.banking.core.persistence.repository;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.ochiai.banking.core.persistence.entity.MovimentacaoCartao;

@Component
public interface MovimentacaoCartaoRepositorioCustom  {
	MovimentacaoCartao pagamento(Date data, BigDecimal valor, String numeroCartao) throws Exception;
	
	MovimentacaoCartao compra(Date data, BigDecimal valor, String numeroCartao) throws Exception;
	
	MovimentacaoCartao estorno(Date data, BigDecimal valor, String numeroCartao) throws Exception;
}