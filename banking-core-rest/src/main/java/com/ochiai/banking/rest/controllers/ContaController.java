package com.ochiai.banking.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ochiai.banking.core.persistence.entity.Conta;
import com.ochiai.banking.core.persistence.service.ContaServico;

/**
 *
 * Controlador de conta
 */
@RestController
@RequestMapping("conta")
public class ContaController {
	@Autowired
	private ContaServico contaServico;
	
    /**
     * Consultar conta pelo Id
     * @param id Id da conta
     * @return dados da conta
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody Conta getConta(@PathVariable int id) {
        return contaServico.findById(id);
    }
}
