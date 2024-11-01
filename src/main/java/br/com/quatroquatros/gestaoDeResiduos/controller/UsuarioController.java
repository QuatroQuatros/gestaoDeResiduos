package br.com.quatroquatros.gestaoDeResiduos.controller;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.helpers.AuthHelpers;
import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import br.com.quatroquatros.gestaoDeResiduos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Page<UsuarioExibicaoDto>> listar(Pageable paginacao){
        return new BaseResponseDto<>(
                "busca de usuários feita com sucesso!",
                service.listarTodos(paginacao)
        );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<UsuarioExibicaoDto> buscarPorId(@PathVariable Long id){
        try{
            return new BaseResponseDto<>(
                    "busca de usuário feita com sucesso!",
                    service.buscarPorId(id)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("usuário não encontrado");
        }

    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<UsuarioExibicaoDto> gravar(@RequestBody @Valid UsuarioCadastroDto usuarioDados){
        return new BaseResponseDto<>(
                "usuário cadastrado com sucesso",
                service.gravar(usuarioDados)
        );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<UsuarioExibicaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioUpdateDto usuarioDados){
        AuthHelpers authHelpers = new AuthHelpers();
        if (authHelpers.validarAcesso(id)) {
            try{
                return new BaseResponseDto<>(
                        "usuário atualizado com sucesso!",
                        service.atualizar(id, usuarioDados)
                );
            }catch (ModelNotFoundException e){
                throw new ModelNotFoundException("usuário não encontrado");
            }
        } else {
            throw new AccessDeniedException("Você não tem permissão para atualizar este usuário.");
        }

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BaseResponseDto<Object> excluir(@PathVariable Long id){
        AuthHelpers authHelpers = new AuthHelpers();
        if (authHelpers.validarAcesso(id)) {
            try{
                service.excluir(id);
                return new BaseResponseDto<>("usuário excluido com sucesso", null);
            }catch (ModelNotFoundException e){
                throw new ModelNotFoundException("usuário não encontrado");
            }
        } else {
            throw new AccessDeniedException("Você não tem permissão para excluír este usuário.");
        }

    }





}
