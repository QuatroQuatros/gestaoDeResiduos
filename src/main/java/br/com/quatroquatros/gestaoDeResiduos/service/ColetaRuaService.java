package br.com.quatroquatros.gestaoDeResiduos.service;

import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaConcluidaDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.interfaces.CRUDInterface;
import br.com.quatroquatros.gestaoDeResiduos.model.ColetaRua;

import java.time.LocalDate;
import java.util.Date;

public interface ColetaRuaService extends CRUDInterface<ColetaRua, Long, ColetaRuaCadastroDto, ColetaRuaUpdateDto, ColetaRuaExibicaoDto> {
    ColetaRuaExibicaoDto marcarColetaComoConcluida(Long idColeta, ColetaRuaConcluidaDto coletaRuaConcluidaDados);



}
