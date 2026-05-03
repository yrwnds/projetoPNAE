package org.example.projetopnae.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenServiceJWT {
    public String gerarToken(User user) {
        try{
            Algorithm algo = Algorithm.HMAC256("PNAE");
            return JWT.create()
                    .withIssuer("API Projeto Extensao PNAE")
                    .withSubject(user.getUsername())
                    .withExpiresAt(dataExpiracao())
                    .sign(algo);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Falha ao gerar token JWT", e);
        }
    }

    private Instant dataExpiracao() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

    public String getSubject(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256("PNAE");
            return JWT.require(algorithm)
                    .withIssuer("API Projeto Extensao PNAE")
                    .build()
                    .verify(token)
                    .getSubject();
        }  catch (JWTVerificationException e) {
            throw new RuntimeException("Token invalido ou expirado.");
        }
    }
}
