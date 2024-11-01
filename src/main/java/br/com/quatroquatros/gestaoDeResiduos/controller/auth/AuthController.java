package br.com.quatroquatros.gestaoDeResiduos.controller.auth;

import br.com.quatroquatros.gestaoDeResiduos.config.security.TokenService;
import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.auth.LoginDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.auth.LoginResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import br.com.quatroquatros.gestaoDeResiduos.service.impl.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private UsuarioServiceImpl service;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public BaseResponseDto<LoginResponseDto> login(@RequestBody @Valid LoginDto usuarioDados) {
        try {
            UsernamePasswordAuthenticationToken usernamePassword =
                    new UsernamePasswordAuthenticationToken(
                            usuarioDados.email(),
                            usuarioDados.senha()
                    );

            Authentication auth = authManager.authenticate(usernamePassword);

            String token = tokenService.gerarToken((Usuario) auth.getPrincipal());

            return new BaseResponseDto<>(
                    "login feito com sucesso!",
                    new LoginResponseDto(
                            new UsuarioExibicaoDto((Usuario) auth.getPrincipal()),
                            token
                    )
            );
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Usuário não cadastrado ou credenciais inválidas.");
        }
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<UsuarioExibicaoDto> register(@RequestBody @Valid UsuarioCadastroDto usuarioDados){
        return new BaseResponseDto<>(
                "usuário registrado com sucesso!",
                service.gravar(usuarioDados)
        );

    }
}
