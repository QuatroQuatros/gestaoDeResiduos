package br.com.quatroquatros.gestaoDeResiduos.controller;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import br.com.quatroquatros.gestaoDeResiduos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public BaseResponseDto<Page<UsuarioExibicaoDto>> listarUsuarios(Pageable paginacao){
        return new BaseResponseDto<>(
                "busca de usuários feita com sucesso!",
                service.listarTodos(paginacao)
        );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<UsuarioExibicaoDto> buscarUsuarioPorId(@PathVariable Long id){
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
    public BaseResponseDto<UsuarioExibicaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid UsuarioUpdateDto usuario){
        try{
            return new BaseResponseDto<>(
                    "usuário atualizado com sucesso!",
                    service.atualizar(id, usuario)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("usuário não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BaseResponseDto<Object> excluir(@PathVariable Long id){
        try{
            service.excluir(id);
            return new BaseResponseDto<>("usuário excluido com sucesso", null);
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("usuário não encontrado");
        }

    }





}
