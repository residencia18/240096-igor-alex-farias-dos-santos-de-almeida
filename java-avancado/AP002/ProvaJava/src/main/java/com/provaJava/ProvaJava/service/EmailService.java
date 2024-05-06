package com.provaJava.ProvaJava.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.provaJava.ProvaJava.repositories.EmailRepository;
import com.provaJava.ProvaJava.domain.Email;
import com.provaJava.ProvaJava.enums.StatusEmail;


// Anotação indicando que esta classe é um serviço gerenciado pelo Spring
@Service
public class EmailService {

    // Injeção de dependência do repositório de email
    @Autowired
    private EmailRepository emailRepository;
    
    // Injeção de dependência do serviço de envio de email do Spring
    @Autowired
    private JavaMailSender emailSender;
    
    // Método para inserir um novo email
    public Email insert(Email email) {
        
        // Define a data e hora de envio do email como o momento atual
        email.setSendDateEmail(LocalDateTime.now());
        
        try {
            // Cria um objeto SimpleMailMessage para o email a ser enviado
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(email.getEmailFrom());
            simpleMailMessage.setTo(email.getEmailTo());
            simpleMailMessage.setSubject(email.getSubject());
            simpleMailMessage.setText(email.getText());
    
            // Envia o email
            emailSender.send(simpleMailMessage);
            // Define o status do email como "ENVIADO" em caso de sucesso
            email.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e) {
            // Em caso de falha no envio do email, define o status como "ERRO"
            email.setStatusEmail(StatusEmail.ERROR);
        } finally {
            // Salva o email no banco de dados e retorna
            return emailRepository.save(email);
        }
    }
}
