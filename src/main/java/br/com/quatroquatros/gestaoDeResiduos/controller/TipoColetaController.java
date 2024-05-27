package br.com.quatroquatros.gestaoDeResiduos.controller;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta.TipoColetaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta.TipoColetaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta.TipoColetaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.service.RuaService;
import br.com.quatroquatros.gestaoDeResiduos.service.TipoColetaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tipoColetas")
public class TipoColetaController {

    private final TipoColetaService service;

    @Autowired
    public TipoColetaController(TipoColetaService service) {
        this.service = service;
    }


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Page<TipoColetaExibicaoDto>> listar(Pageable paginacao){
        return new BaseResponseDto<>(
                "busca de tipos de coletas feita com sucesso!",
                service.listarTodos(paginacao)
        );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<TipoColetaExibicaoDto> buscaPorId(@PathVariable Long id){
        try{
            return new BaseResponseDto<>(
                    "busca de tipos de coletas feita com sucesso!",
                    service.buscarPorId(id)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("tipo de coleta não encontrado");
        }

    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<TipoColetaExibicaoDto> gravar(@RequestBody @Valid TipoColetaCadastroDto tipoColetaDados){
        return new BaseResponseDto<>(
                "tipo de coleta cadastrado com sucesso!",
                service.gravar(tipoColetaDados)
        );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<TipoColetaExibicaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid TipoColetaUpdateDto tipoColetaDados){
        try {
            return new BaseResponseDto<>(
                    "tipo de coleta atualizado com sucesso!",
                    service.atualizar(id, tipoColetaDados)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("tipo de coleta não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<TipoColetaExibicaoDto> excluir(@PathVariable Long id){
        try {
            service.excluir(id);
            return new BaseResponseDto<>("tipo de coleta excluido com sucesso");
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("tipo de coleta não encontrado");
        }
    }
}
