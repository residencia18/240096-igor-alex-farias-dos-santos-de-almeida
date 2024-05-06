package com.provaJava.ProvaJava.resources;

import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.bind.annotation.*;
import com.provaJava.ProvaJava.domain.Email;
import com.provaJava.ProvaJava.resources.dto.EmailDTO;
import com.provaJava.ProvaJava.service.EmailService;
import jakarta.validation.Valid;

@RestController
public class EmailResource {

	// Logger para registrar mensagens de log
	private static final Logger LOGGER = LoggerFactory.getLogger(EmailResource.class);

	// Serviço de envio de emails
	@Autowired
	private EmailService emailService;

	 // Endpoint POST para enviar email
	@PostMapping("/sending-email")
	public ResponseEntity<Email> sendingEmail(@RequestBody @Valid EmailDTO emailDto, UriComponentsBuilder uriC){
		try {

			// Cria um objeto Email a partir dos dados fornecidos no DTO
            Email email = new Email();
            BeanUtils.copyProperties(emailDto, email);
            
            // Insere o email no banco de dados e retorna o email inserido
            emailService.insert(email);
            
            // Constrói a URI do recurso criado
            URI uri = uriC.path("/sending-email/{id}").buildAndExpand(email.getId()).toUri();
            
            // Registra uma mensagem de log indicando o envio do email
            LOGGER.info(" Email sendo enviado ");
            
            // Retorna uma resposta com status CREATED e o email inserido
            return ResponseEntity.created(uri).body(email);
        } catch (Exception e) {
            // Se ocorrer uma exceção, retorna uma resposta com status NOT FOUND
            return ResponseEntity.notFound().build();
        }
    }
}
