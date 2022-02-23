package com.ochiai.banking.card.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * Spring Boot application starter class
 */
@SpringBootApplication(scanBasePackages = {"com.ochiai.banking.core","com.ochiai.banking.card.rest","com.ochiai.banking.mensageria"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
