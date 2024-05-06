package com.provaJava.ProvaJava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.provaJava.ProvaJava.domain.Email;
import com.provaJava.ProvaJava.enums.StatusEmail;
import com.provaJava.ProvaJava.repositories.EmailRepository;

import java.time.LocalDateTime;
import java.util.Optional;

// Anotação que indica que este é um teste de repositório JPA
@DataJpaTest
public class EmailRepositoryTests {

    @Autowired
    private EmailRepository emailRepository;

    // Variáveis utilizadas nos testes
    private Long IdExistente;
    private String ReferenciaDono;
    
	// Método executado antes de cada teste para configurar variáveis
	@BeforeEach
	void setUp() throws Exception{
		IdExistente = 1L;
		ReferenciaDono = " Referencia Dono ";
	}

	// Teste para verificar se é possível buscar um email pelo ID
	@Test
	public void searchByIdWithReturnID(){
	    Optional<Email> result = Optional.ofNullable(emailRepository.getReferenceById(IdExistente));
	    Assertions.assertTrue(result.isPresent()); 

	    Email email = result.get(); 
	    Assertions.assertNotNull(email.getId());
	    Assertions.assertEquals(IdExistente, email.getId());
	}
	
    // Teste para verificar se é possível salvar um email
    // Verifica se o ID é gerado automaticamente quando é nulo
    @Test
    public void saveShouldPersistWithAutoincrementWhenIdIsNull() {
        // Cria um objeto de Email
        Email email = new Email();
        email.setSendDateEmail(LocalDateTime.now());
        email.setReferenciaDono(" Referencia dono ");
        email.setEmailFrom(" from@example.com ");
        email.setEmailTo(" to@example.com ");
        email.setSubject(" Test Subject ");
        email.setText(" Test Content ");
        email.setStatusEmail(StatusEmail.SENT);
        email.setId(null);

        // Salva o email no repositório
        email = emailRepository.save(email);

        // Verifica se o ID foi gerado automaticamente
        Assertions.assertNotNull(email.getId());
    }
}
