package com.provaJava.ProvaJava.resources.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// Classe DTO (Data Transfer Object) para os dados de email
@Data
public class EmailDTO {
    
    // Referência do proprietário do email
    @NotBlank(message = " Não pode ser vazio nem null ")
    private String ReferenciaDono;
    
    // Endereço de email do remetente
    @Email
    @NotBlank(message = " Não pode ser vazio nem null ")
    private String emailFrom;
    
    // Endereço de email do destinatário
    @Email
    @NotBlank(message = " Não pode ser vazio nem null ")
    private String emailTo;
    
    // Assunto do email
    @NotBlank(message = " Não pode ser vazio nem null ")
    private String subject;
    
    // Conteúdo do email
    @NotBlank(message = " Não pode ser vazio nem null ")
    private String text;
}
