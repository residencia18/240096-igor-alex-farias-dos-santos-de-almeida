package com.provaJava.ProvaJava.security;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.provaJava.ProvaJava.repositories.UserRepository;
import com.provaJava.ProvaJava.domain.User;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    
    // Método para carregar os detalhes do usuário pelo nome de usuário (email)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca o usuário no banco de dados pelo email
        User user = this.userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(" Usuário não encontrado "));
        // Retorna um UserDetails contendo o email, senha criptografada e uma lista vazia de autoridades
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
