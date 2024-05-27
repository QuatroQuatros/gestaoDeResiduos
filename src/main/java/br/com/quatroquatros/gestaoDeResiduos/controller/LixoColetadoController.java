package br.com.quatroquatros.gestaoDeResiduos.controller;


import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado.LixoColetadoCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado.LixoColetadoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado.LixoColetadoUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.service.LixoColetadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lixoColetado")
public class LixoColetadoController {


    private final LixoColetadoService service;

    @Autowired
    public LixoColetadoController(LixoColetadoService service) {
        this.service = service;
    }


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Page<LixoColetadoExibicaoDto>> listar(Pageable paginacao){
        return new BaseResponseDto<>(
                "busca de lixo coletado feita com sucesso!",
                service.listarTodos(paginacao)
        );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<LixoColetadoExibicaoDto> buscarPorId(@PathVariable Long id){
        try{
            return new BaseResponseDto<>(
                    "busca de lixo coletado feita com sucesso!",
                    service.buscarPorId(id)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("lixo coletado não encontrado");
        }

    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<LixoColetadoExibicaoDto> gravar(@RequestBody @Valid LixoColetadoCadastroDto lixoColetadoDados){
        return new BaseResponseDto<>(
                "lixo coletado cadastrado com sucesso!",
                service.gravar(lixoColetadoDados)
        );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<LixoColetadoExibicaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid LixoColetadoUpdateDto lixoColetadoDados){
        try {
            return new BaseResponseDto<>(
                    "lixo coletado atualizado com sucesso!",
                    service.atualizar(id, lixoColetadoDados)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("lixo coletado não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<LixoColetadoExibicaoDto> excluir(@PathVariable Long id){
        try {
            service.excluir(id);
            return new BaseResponseDto<>("lixo coletado excluido com sucesso");
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("lixo coletado não encontrado");
        }
    }
}
