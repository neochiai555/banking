package com.ochiai.banking.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ochiai.banking.core.persistence.entity.Agencia;
import com.ochiai.banking.core.persistence.service.AgenciaServico;


/**
 *
 * Controlador de agencia
 */
@RestController
@RequestMapping("agencia")
public class AgenciaController {
	@Autowired
	private AgenciaServico agenciaServico;
	
    /**
     * Consultar agencia pelo Id
     * @param id Id da agencia
     * @return dados da agencia
     */
    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody Agencia getAgencia(@PathVariable int id) {
        return agenciaServico.findById(id);
    }
}
