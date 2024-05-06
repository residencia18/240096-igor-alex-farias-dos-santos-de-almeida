package com.provaJava.ProvaJava.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.provaJava.ProvaJava.repositories.UserRepository;
import com.provaJava.ProvaJava.resources.dto.AuthenticationDTO;
import com.provaJava.ProvaJava.resources.dto.LoginResponseDTO;
import com.provaJava.ProvaJava.resources.dto.RegisterDTO;
import com.provaJava.ProvaJava.security.TokenService;
import com.provaJava.ProvaJava.domain.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthResource {
    
    // Logger para registrar mensagens de log
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthResource.class);
    
    // Repositório de usuários
    private final UserRepository userRepository;
    
    // Encoder de senha
    private final PasswordEncoder passwordEncoder;
    
    // Serviço de token JWT
    private final TokenService tokenService;
    
    // Endpoint POST para realizar login
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        // Registra uma mensagem de log indicando a operação de login
        LOGGER.info(" Fazendo Login ", data.email());
        
        // Busca o usuário no banco de dados pelo email fornecido
        User user = this.userRepository.findByEmail(data.email()).orElseThrow(() -> new RuntimeException("User not found"));
        
        // Verifica se a senha fornecida corresponde à senha do usuário no banco de dados
        if (this.passwordEncoder.matches(data.password(), user.getPassword())) {
            // Gera um token JWT para o usuário
            String token = this.tokenService.generateToken(user);
            // Retorna uma resposta com status OK contendo o token JWT e o nome do usuário
            return ResponseEntity.ok(new LoginResponseDTO(user.getName(), token));
        }
        
        // Se a senha fornecida não corresponder à senha do usuário, retorna uma resposta com status BadRequest
        return ResponseEntity.badRequest().build();
    }
    
    // Endpoint POST para registrar um novo usuário
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        // Registra uma mensagem de log indicando a operação de registro de usuário
        LOGGER.info(" Registrando Usuário ", data.email());
        
        // Verifica se já existe um usuário com o email fornecido
        Optional<User> existingUser = this.userRepository.findByEmail(data.email());
        
        // Se não existir um usuário com o email fornecido
        if (existingUser.isEmpty()) {
            // Cria um novo usuário com os dados fornecidos
            User newUser = new User();
            newUser.setPassword(passwordEncoder.encode(data.password()));
            newUser.setEmail(data.email());
            newUser.setName(data.name());
            
            // Salva o novo usuário no banco de dados
            this.userRepository.save(newUser);
            
            // Gera um token JWT para o novo usuário
            String token = this.tokenService.generateToken(newUser);
            
            // Retorna uma resposta com status OK contendo o token JWT e o nome do usuário
            return ResponseEntity.ok(new LoginResponseDTO(newUser.getName(), token));
        }
        
        // Se já existir um usuário com o email fornecido, retorna uma resposta com status BadRequest
        return ResponseEntity.badRequest().build();
    }
}
