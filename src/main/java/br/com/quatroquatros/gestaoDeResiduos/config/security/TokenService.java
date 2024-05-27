package br.com.quatroquatros.gestaoDeResiduos.config.security;

import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${minha.chave.secreta}")
    private String palavraSecreta;

    public String gerarToken(Usuario usuario){
        try{
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);
            String token = JWT.create()
                    .withIssuer("gestaoResiduos")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(this.gerarDataExpiracao())
                    .sign(algorithm);
            return token;

        }catch (JWTCreationException exception){
            throw  new RuntimeException("Erro ao criar token");
        }
    }


    public String validarToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);
            return JWT.require(algorithm)
                    .withIssuer("gestaoResiduos")
                    .build()
                    .verify(token)
                    .getSubject();
        }catch (JWTVerificationException error){
            return "";
        }
    }

    public Instant gerarDataExpiracao(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
