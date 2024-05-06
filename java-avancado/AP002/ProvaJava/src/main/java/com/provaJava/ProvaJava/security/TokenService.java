package com.provaJava.ProvaJava.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.provaJava.ProvaJava.domain.User;

@Service
public class TokenService {
	
	// Injeção da chave secreta do token a partir das propriedades configuradas
	@Value("${api.security.token.secret}")
	private String secret;
	
	// Método para gerar um token JWT para um usuário
	public String generateToken(User user) {
		try {
			// Cria um algoritmo de assinatura com a chave secreta
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			// Cria e assina o token JWT com os dados do usuário
			String token = JWT.create()
					.withIssuer(" TokenProva ")
					.withSubject(user.getEmail())
					.withExpiresAt(this.genExpirationDate())
					.sign(algorithm);
			
			return token;
	    } catch (JWTCreationException exception) {
	        throw new RuntimeException(" Erro gerando token ", exception);
	    }
	}
	
	// Método para gerar um token JWT para redefinição de senha
	public String generateTokenReset(String password) {
		try {
			// Cria um algoritmo de assinatura com a chave secreta
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			// Cria e assina o token JWT com a senha fornecida
			String token = JWT.create()
					.withIssuer(" TokenProva ")
					.withSubject(password)
					.withExpiresAt(this.genExpirationDate())
					.sign(algorithm);
			
			return token;
	    } catch (JWTCreationException exception) {
	        throw new RuntimeException(" Erro gerando token ", exception);
	    }
	}
	
	// Método para validar um token JWT e extrair o assunto (subject)
	public String validateToken(String token) {
		try {
			// Cria um algoritmo de verificação com a chave secreta
			Algorithm algorithm = Algorithm.HMAC256(secret);
			
			// Verifica e decodifica o token JWT e extrai o assunto (subject)
			return JWT.require(algorithm)
					.withIssuer(" TokenProva ")
					.build()
					.verify(token)
					.getSubject();	
        } catch (JWTVerificationException exception){
            return null;
        }
	}
	
	// Método privado para gerar a data de expiração do token
	private Instant genExpirationDate(){
	    return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of(" -05:00 "));
	}
}
