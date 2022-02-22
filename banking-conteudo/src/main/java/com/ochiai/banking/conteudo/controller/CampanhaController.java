package com.ochiai.banking.conteudo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ochiai.banking.conteudo.model.CampanhaModel;
import com.ochiai.banking.conteudo.persistence.entity.Campanha;
import com.ochiai.banking.conteudo.persistence.service.CampanhaServico;

/**
 *
 * Controlador de campanha
 */
@RestController
@RequestMapping("campanha")
public class CampanhaController {
	@Autowired
	private CampanhaServico campanhaServico;
	
    /**
     * Consultar campanhas
     * @return campanhas
     */
    @GetMapping(value = "/", produces = "application/json")
    public @ResponseBody List<Campanha> getCampanhas() {
        return campanhaServico.findAll();
    }
    
    /**
     * Inserir campanha
     * @return campanha
     */
    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<Campanha> criarCampanha(@RequestBody CampanhaModel model) {
        return ResponseEntity.ok(campanhaServico.criar(model.getNome(), model.getTipo(), model.getDescricao()));
    }
}
