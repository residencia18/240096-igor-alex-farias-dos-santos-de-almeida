package com.provaJava.ProvaJava.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.provaJava.ProvaJava.domain.User;

// Interface do repositório para entidade User
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Método para buscar um usuário pelo email
    Optional<User> findByEmail(String email);
}
