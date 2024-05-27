package br.com.quatroquatros.gestaoDeResiduos.controller;


import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.service.RuaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ruas")
public class RuaController {

    private final RuaService service;

    @Autowired
    public RuaController(RuaService service) {
        this.service = service;
    }


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Page<RuaExibicaoDto>> listarRuas(Pageable paginacao){
        return new BaseResponseDto<>(
                "busca de ruas feita com sucesso!",
                service.listarTodos(paginacao)
        );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<RuaExibicaoDto> buscarRuaPorId(@PathVariable Long id){
        try{
            return new BaseResponseDto<>(
                    "busca de ruas feita com sucesso!",
                    service.buscarPorId(id)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("rua não encontrada");
        }

    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<RuaExibicaoDto> gravar(@RequestBody @Valid RuaCadastroDto ruaDados){
        return new BaseResponseDto<>(
                "rua cadastrada com sucesso!",
                service.gravar(ruaDados)
        );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<RuaExibicaoDto> atualizar(@PathVariable Long id, @RequestBody RuaUpdateDto ruaDados){
        try {
            return new BaseResponseDto<>(
                    "rua atualizada com sucesso!",
                    service.atualizar(id, ruaDados)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("rua não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<RuaExibicaoDto> excluir(@PathVariable Long id){
        try {
            service.excluir(id);
            return new BaseResponseDto<>("rua excluida com sucesso");
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("rua não encontrada");
        }
    }
}
