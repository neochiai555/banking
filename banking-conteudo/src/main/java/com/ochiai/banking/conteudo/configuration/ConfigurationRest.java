package com.ochiai.banking.conteudo.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@EntityScan(basePackages = {"com.ochiai.banking.conteudo.entity"})
@ComponentScan(basePackages = {"com.ochiai.banking.conteudo.service"})
public class ConfigurationRest {

}