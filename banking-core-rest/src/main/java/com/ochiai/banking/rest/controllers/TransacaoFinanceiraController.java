package com.ochiai.banking.rest.controllers;

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

import com.ochiai.banking.core.exception.SaldoInsuficienteException;
import com.ochiai.banking.core.model.TransacaoModel;
import com.ochiai.banking.core.persistence.entity.Movimentacao;
import com.ochiai.banking.core.persistence.service.AgenciaServico;
import com.ochiai.banking.core.persistence.service.ContaServico;
import com.ochiai.banking.core.persistence.service.MovimentacaoServico;

/**
 *
 * Controlador de transacoes financeiras
 */
@RestController
@RequestMapping("transacaoFinanceira")
public class TransacaoFinanceiraController {
	@Autowired
	private AgenciaServico agenciaServico;
	
	@Autowired
	private ContaServico contaServico;
	
	@Autowired 
	private MovimentacaoServico movimentacaoServico;

	/**
	 * Consultar movimentacoes da conta
	 * @param id Id da conta
	 * @return movimentacoes da conta
	 */
	@GetMapping(value = "/extrato", produces = "application/json")
	public @ResponseBody List<Movimentacao> extrato(@RequestParam(name = "idConta") int idConta) {
	    return movimentacaoServico.findByIdConta(idConta);
	}	
	
	/**
	 * Depositar valor na conta
	 * @param id Id da conta
	 * @param valor
	 * @return movimentacao resultante
	 */
	@PostMapping(value = "/deposito", produces = "application/json")
	public ResponseEntity<Movimentacao> deposito(@RequestBody TransacaoModel model) {
		try {
			return ResponseEntity.ok(movimentacaoServico.deposito(
				model.getData(), model.getValor(),
				model.getNumeroAgencia(), model.getDigitoAgencia(),
				model.getNumeroConta(), model.getDigitoConta()));
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}	

	/**
	 * Sacar valor da conta
	 * @param id Id da conta
	 * @param valor
	 * @return movimentacao resultante
	 */
	@PostMapping(value = "/saque", produces = "application/json")
	public ResponseEntity<Movimentacao> saque(@RequestBody TransacaoModel model) {
		try {
			return ResponseEntity.ok(movimentacaoServico.saque(
				model.getData(), model.getValor(),
				model.getNumeroAgencia(), model.getDigitoAgencia(),
				model.getNumeroConta(), model.getDigitoConta()));
		} catch (SaldoInsuficienteException ex) {
			return ResponseEntity.badRequest().build();
		} catch (Exception ex) {
			return ResponseEntity.internalServerError().build();
		}
	}
}
