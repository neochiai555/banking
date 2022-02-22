package com.ochiai.banking.card.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ochiai.banking.core.model.TransacaoCartaoModel;
import com.ochiai.banking.core.persistence.entity.MovimentacaoCartao;
import com.ochiai.banking.core.persistence.service.CartaoServico;
import com.ochiai.banking.core.persistence.service.MovimentacaoCartaoServico;

/**
 *
 * Controlador de transacoes financeiras de cartao
 */
@RestController
@RequestMapping("transacaoFinanceira")
public class TransacaoFinanceiraController {
	@Autowired
	private CartaoServico cartaoServico;
	
	@Autowired 
	private MovimentacaoCartaoServico movimentacaoCartaoServico;

	/**
	 * Consultar movimentacoes do cartao
	 * @param id Id do cartao
	 * @return movimentacoes do cartao
	 */
	@GetMapping(value = "/extrato", produces = "application/json")
	public @ResponseBody List<MovimentacaoCartao> extrato(@RequestParam(name = "idCartao") int idCartao) {
	    return movimentacaoCartaoServico.findByIdCartao(idCartao);
	}	
	
	/**
	 * Pagar valor da fatura cartao
	 * @param model
	 * @return movimentacao resultante
	 */
	@PostMapping(value = "/pagamento", produces = "application/json")
	public ResponseEntity<MovimentacaoCartao> pagamento(@RequestBody TransacaoCartaoModel model) {
		try {
			return ResponseEntity.ok(movimentacaoCartaoServico.pagamento(
					model.getData(), 
					model.getValor(), 
					model.getNumeroCartao()));
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}	

	/**
	 * Efetuar compra no cartao
	 * @param model
	 * @return movimentacao resultante
	 */
	@PostMapping(value = "/compra", produces = "application/json")
	public ResponseEntity<MovimentacaoCartao> compra(@RequestBody TransacaoCartaoModel model) {
		try {
			return ResponseEntity.ok(movimentacaoCartaoServico.compra(
					model.getData(), 
					model.getValor(), 
					model.getNumeroCartao()));
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}	
	
	/**
	 * Estornar valor no cartao
	 * @param model
	 * @return movimentacao resultante
	 */
	@PostMapping(value = "/estorno", produces = "application/json")
	public ResponseEntity<MovimentacaoCartao> estorno(@RequestBody TransacaoCartaoModel model) {
		try {
			return ResponseEntity.ok(movimentacaoCartaoServico.estorno(
					model.getData(), 
					model.getValor(), 
					model.getNumeroCartao()));
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}	
}
