package com.provaJava.ProvaJava.domain;

import java.time.LocalDateTime;

import com.provaJava.ProvaJava.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Esta classe representa um email no sistema
@Getter
@Setter
@Entity
@Table(name = "tabela_email") // Define o nome da tabela no banco de dados
@AllArgsConstructor // Anotação do Lombok para gerar um construtor com todos os argumentos
@NoArgsConstructor // Anotação do Lombok para gerar um construtor vazio
public class Email {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ReferenciaDono;
    private String emailFrom;
    private String emailTo;
    private String subject;

    @Column(columnDefinition = "TEXT") // Define o tipo de coluna como texto longo
    private String text;
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
}
