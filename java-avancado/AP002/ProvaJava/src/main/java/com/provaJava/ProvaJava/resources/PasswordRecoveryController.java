package com.provaJava.ProvaJava.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.provaJava.ProvaJava.domain.User;
import com.provaJava.ProvaJava.repositories.UserRepository;
import com.provaJava.ProvaJava.resources.dto.EmailRequestDTO;
import com.provaJava.ProvaJava.resources.dto.PasswordRecoveryDTO;
import com.provaJava.ProvaJava.security.TokenService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PasswordRecoveryController {
	private static final Logger LOGGER = LoggerFactory.getLogger(PasswordRecoveryController.class);
	
    private final UserRepository userRepository;
    private final TokenService tokenService;
    
    
    @PostMapping("/solicitaReset")
    public ResponseEntity resetPassword(@RequestBody EmailRequestDTO data) {
    	
    	User user = this.userRepository.findByEmail(data.email()).orElseThrow(()->new RuntimeException(" Usuário não encontrado. "));
    	LOGGER.info(" Resetando senha ", data.email());
    	if(user.getEmail().equals(data.email())) {

    		String token = this.tokenService.generateToken(user);
    		
    		String url_reset_password = "http://localhost:8080/redefinir-senha";
    		return ResponseEntity.ok(new PasswordRecoveryDTO(user.getEmail(), token, url_reset_password));
    	}
    	
    	return ResponseEntity.badRequest().build();
    }
    

    
    
}
