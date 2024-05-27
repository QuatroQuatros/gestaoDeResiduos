package br.com.quatroquatros.gestaoDeResiduos.controller;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.service.RegiaoService;
import br.com.quatroquatros.gestaoDeResiduos.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/regioes")
public class RegiaoController {

    private final RegiaoService service;

    @Autowired
    public RegiaoController(RegiaoService service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Page<RegiaoExibicaoDto>> listarRegioes(Pageable paginacao){

        return new BaseResponseDto<>(
                "Busca de regiões feita com sucesso!",
                service.listarTodos(paginacao)
        );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<RegiaoExibicaoDto> buscarRegiaoPorId(@PathVariable Long id){
        try {
            return new BaseResponseDto<>(
                    "busca de região feita com sucesso!",
                    service.buscarPorId(id)
            );
        } catch (ModelNotFoundException e) {
            throw new ModelNotFoundException("região não encontrada");

        }
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<RegiaoExibicaoDto> gravar(@RequestBody @Valid RegiaoCadastroDto regiaoDados){
        return new BaseResponseDto<>(
                "região cadastrada com sucesso!",
                service.gravar(regiaoDados)
        );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<RegiaoExibicaoDto> atualizar(@PathVariable Long id, @RequestBody RegiaoUpdateDto regiaoDados){
        try {
            return new BaseResponseDto<>(
                        "região atualizada com sucesso!",
                        service.atualizar(id, regiaoDados)
                );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("região não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Object> excluir(@PathVariable Long id) {
        try {
            service.excluir(id);
            return new BaseResponseDto<>("região excluida com sucesso");
        } catch (ModelNotFoundException e) {
            throw new ModelNotFoundException("região não encontrada");

        }
    }
}
