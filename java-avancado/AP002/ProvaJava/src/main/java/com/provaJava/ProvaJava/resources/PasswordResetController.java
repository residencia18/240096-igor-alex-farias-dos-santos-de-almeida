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
import com.provaJava.ProvaJava.resources.dto.LoginResponseDTO;
import com.provaJava.ProvaJava.resources.dto.ResetPasswordDTO;
import com.provaJava.ProvaJava.security.TokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PasswordResetController {
    
    // Logger para registrar mensagens de log
    private static final Logger LOGGER = LoggerFactory.getLogger(PasswordRecoveryController.class);
    
    // Repositório de usuários
    private final UserRepository userRepository;
    
    // Encoder de senha
    private final PasswordEncoder passwordEncoder;
    
    // Serviço de token JWT
    private final TokenService tokenService;
    
    // Endpoint POST para redefinir a senha do usuário
    @PostMapping("/redefinir-senha")
    public ResponseEntity resetPassword(@RequestBody @Valid ResetPasswordDTO data) {
        // Busca o usuário no banco de dados pelo email fornecido
        User user = this.userRepository.findByEmail(data.email()).orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        
        // Registra uma mensagem de log indicando a tentativa de redefinição de senha
        LOGGER.info(" Resetando senha ", data.email(), data.password(), data.newPassword());
        
        // Verifica se a senha fornecida coincide com a senha atual do usuário
        if (this.passwordEncoder.matches(data.password(), user.getPassword())) {
            // Gera um novo token de redefinição de senha
            String token = this.tokenService.generateTokenReset(user.getPassword());
            
            // Atualiza a senha do usuário no banco de dados com a nova senha
            user.setPassword(this.passwordEncoder.encode(data.newPassword()));
            this.userRepository.save(user);
            
            // Retorna uma resposta com status OK e os dados do usuário e o token
            return ResponseEntity.ok(new LoginResponseDTO(user.getName(), token));
        }
        
        // Se a senha fornecida não coincidir com a senha atual do usuário, retorna uma resposta com status BadRequest
        return ResponseEntity.badRequest().build();
    }
}
