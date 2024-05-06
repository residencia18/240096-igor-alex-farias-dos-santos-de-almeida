package com.provaJava.ProvaJava.resources.dto;

// Classe DTO (Data Transfer Object) para os dados de redefinição de senha
public record ResetPasswordDTO(String email, String password, String newPassword) {
}