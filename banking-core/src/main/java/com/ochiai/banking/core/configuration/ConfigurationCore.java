package com.ochiai.banking.core.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages ={"com.ochiai.banking.core.persistence.repository","com.ochiai.banking.core.persistence.repository.impl"})
@EntityScan(basePackages = {"com.ochiai.banking.core.persistence.entity"})
@ComponentScan(basePackages = {"com.ochiai.banking.core.persistence.service"})
public class ConfigurationCore {

}
