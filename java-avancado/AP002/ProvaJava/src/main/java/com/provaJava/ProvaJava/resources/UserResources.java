package com.provaJava.ProvaJava.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserResources {
    
    // Logger para registrar mensagens de log
    private static final Logger LOGGER = LoggerFactory.getLogger(UserResources.class);
    
    // Endpoint GET para obter informações do usuário
    @GetMapping
    public ResponseEntity<String> getUser() {
        // Registra uma mensagem de log indicando que o endpoint getUser foi acessado
        LOGGER.info(" Utilizando getUser. ");
        // Retorna uma resposta com status OK e uma mensagem de sucesso
        return ResponseEntity.ok(" Deu certo ");
    }
}
