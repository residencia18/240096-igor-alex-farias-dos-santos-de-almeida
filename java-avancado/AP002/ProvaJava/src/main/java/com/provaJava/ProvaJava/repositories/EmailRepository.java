package com.provaJava.ProvaJava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.provaJava.ProvaJava.domain.Email;

// Interface do repositório para entidade Email
public interface EmailRepository extends JpaRepository<Email, Long> {

}
