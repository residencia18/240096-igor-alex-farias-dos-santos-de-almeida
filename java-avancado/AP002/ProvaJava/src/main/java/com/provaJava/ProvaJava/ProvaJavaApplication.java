package com.provaJava.ProvaJava;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;


// Anotação que indica que esta classe é a classe principal do Spring Boot
@SpringBootApplication
public class ProvaJavaApplication {

    // Criação de um logger para esta classe
    private static final Logger LOGGER = LoggerFactory.getLogger(ProvaJavaApplication.class);

    // Método principal que inicia a aplicação Spring Boot
    public static void main(String[] args) {
        // Inicia a aplicação Spring Boot
        SpringApplication.run(ProvaJavaApplication.class, args);
        
        // Loga uma mensagem indicando que a aplicação está funcionando
        LOGGER.info(" Funcionando ");
    }

}
