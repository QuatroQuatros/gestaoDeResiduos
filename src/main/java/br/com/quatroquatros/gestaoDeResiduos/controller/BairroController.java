package br.com.quatroquatros.gestaoDeResiduos.controller;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.BairroCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.BairroExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.BairroUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.service.BairroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bairros")
public class BairroController {


    private final BairroService service;

    @Autowired
    public BairroController(BairroService service) {
        this.service = service;
    }


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Page<BairroExibicaoDto>> listar(Pageable paginacao){
        return new BaseResponseDto<>(
                "busca de bairros feita com sucesso!",
                service.listarTodos(paginacao)
        );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<BairroExibicaoDto> buscarPorId(@PathVariable Long id){
        try{
            return new BaseResponseDto<>(
                    "busca de bairro feita com sucesso!",
                    service.buscarPorId(id)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("bairro não encontrado");
        }

    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<BairroExibicaoDto> gravar(@RequestBody @Valid BairroCadastroDto bairroDados){
        return new BaseResponseDto<>(
                "bairro cadastrado com sucesso!",
                service.gravar(bairroDados)
        );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<BairroExibicaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid BairroUpdateDto bairroDados){
        try {
            return new BaseResponseDto<>(
                    "bairro atualizado com sucesso!",
                    service.atualizar(id, bairroDados)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("bairro não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<BairroExibicaoDto> excluir(@PathVariable Long id){
        try {
            service.excluir(id);
            return new BaseResponseDto<>("bairro excluido com sucesso");
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("bairro não encontrado");
        }
    }
}
