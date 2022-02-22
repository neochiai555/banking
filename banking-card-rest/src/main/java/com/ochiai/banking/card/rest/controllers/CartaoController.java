package com.ochiai.banking.card.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ochiai.banking.core.persistence.entity.Cartao;
import com.ochiai.banking.core.persistence.service.CartaoServico;

/**
 *
 * Controlador de cartao
 */
@RestController
@RequestMapping("cartao")
public class CartaoController {
	@Autowired
	private CartaoServico cartaoServico;
	
    /**
     * Consultar cartao pelo Id
     * @param id Id do cartao
     * @return dados do cartao
     */
    @GetMapping(value = "/id/{id}", produces = "application/json")
    public @ResponseBody Cartao getCartao(@PathVariable int id) {
        return cartaoServico.findById(id);
    }
    
    /**
     * Consultar cartao pelo numero
     * @param numero Numero do cartao
     * @return dados do cartao
     */
    @GetMapping(value = "/numero/{numero}", produces = "application/json")
    public @ResponseBody Cartao getCartaoPorNumero(@PathVariable String numero) {
        List<Cartao> cartoes = cartaoServico.findByNumeroCartao(numero);
        
        return cartoes.get(0);
    }
}
