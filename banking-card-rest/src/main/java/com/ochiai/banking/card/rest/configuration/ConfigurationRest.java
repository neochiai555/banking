package com.ochiai.banking.card.rest.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.ochiai.banking.core.configuration.ConfigurationCore;

@Configuration
@EnableAutoConfiguration
@Import(value = {ConfigurationCore.class})
public class ConfigurationRest {

}