package com.provaJava.ProvaJava.resources.dto;

// Classe DTO (Data Transfer Object) para os dados de recuperação de senha
public record PasswordRecoveryDTO(String email, String token, String url) {
}
