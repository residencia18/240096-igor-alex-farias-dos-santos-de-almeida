package com.provaJava.ProvaJava.security;

import java.io.IOException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.provaJava.ProvaJava.domain.User;
import com.provaJava.ProvaJava.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    
    @Autowired
    TokenService tokenService;
    
    @Autowired
    UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Recupera o token da requisição
        var token = this.recoverToken(request);
        
        // Valida o token
        var login = tokenService.validateToken(token);
        
        // Se o token for válido
        if(login != null) {
            // Busca o usuário no repositório pelo e-mail
            User user = userRepository.findByEmail(login).orElseThrow(() -> new RuntimeException(" Usuário não encontrado "));
            
            // Define as autoridades do usuário como ROLE_USER
            var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            
            // Cria uma autenticação com o usuário e as autoridades
            var authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
            
            // Define a autenticação no contexto de segurança
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        
        // Segue para o próximo filtro na cadeia
        filterChain.doFilter(request, response);
    }

    // Método para recuperar o token da requisição
    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader(" Authorization ");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }

}
