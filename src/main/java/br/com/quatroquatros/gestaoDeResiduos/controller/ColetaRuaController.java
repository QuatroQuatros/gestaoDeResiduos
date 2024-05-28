package br.com.quatroquatros.gestaoDeResiduos.controller;


import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaConcluidaDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.service.ColetaRuaService;
import br.com.quatroquatros.gestaoDeResiduos.service.EstadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/coletas")
public class ColetaRuaController {


    private final ColetaRuaService service;

    @Autowired
    public ColetaRuaController(ColetaRuaService service) {
        this.service = service;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<Page<ColetaRuaExibicaoDto>> listar(Pageable paginacao){
        return new BaseResponseDto<>(
                "busca de coletas feita com sucesso!",
                service.listarTodos(paginacao)
        );
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<ColetaRuaExibicaoDto> buscarPorId(@PathVariable Long id){
        try{
            return new BaseResponseDto<>(
                    "busca de coleta feita com sucesso!",
                    service.buscarPorId(id)
            );
        }catch (ModelNotFoundException e){
            throw new ModelNotFoundException("coleta não encontrada");
        }

    }

    @PostMapping("/agendar")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<Object> agendar(@RequestBody @Valid ColetaRuaCadastroDto coletaRuaDados){
        return new BaseResponseDto<>(
                "agendamento feito sucesso!",
                service.gravar(coletaRuaDados)
        );
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseResponseDto<ColetaRuaExibicaoDto> atualizar(@PathVariable Long id, @RequestBody @Valid ColetaRuaUpdateDto coletaRuaDados){
        try {
            return new BaseResponseDto<>(
                    "coleta atualizada com sucesso!",
                    service.atualizar(id, coletaRuaDados)
            );
        } catch (ModelNotFoundException e) {
            throw new ModelNotFoundException("coleta não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public BaseResponseDto<ColetaRuaExibicaoDto> excluir(@PathVariable Long id){
        try {
            service.excluir(id);
            return new BaseResponseDto<>("coleta excluida com sucesso");
        } catch (ModelNotFoundException e) {
            throw new ModelNotFoundException("coleta não encontrada");
        }
    }

    @PostMapping("/{coletaId}/concluir")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<ColetaRuaExibicaoDto> concluirColeta(@PathVariable Long coletaId, @RequestBody @Valid ColetaRuaConcluidaDto dados){
        try {
            return new BaseResponseDto<>(
                    "coleta concluida com sucesso!",
                    service.marcarColetaComoConcluida(coletaId, dados)
            );
        } catch (ModelNotFoundException e) {
            throw new ModelNotFoundException("coleta não encontrada");
        }
    }

    @GetMapping("/agendamentos")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseResponseDto<List<ColetaRuaExibicaoDto>> buscarAgendamentosPorIntervaloDeTempo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFinal){

        return new BaseResponseDto<>(
                "busca agendamentos com sucesso!",
                service.buscarAgendamentosPorIntervaloDeTempo(dataInicial, dataFinal)
        );

    }
}
