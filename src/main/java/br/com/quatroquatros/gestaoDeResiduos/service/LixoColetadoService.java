package br.com.quatroquatros.gestaoDeResiduos.service;

import br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado.LixoColetadoCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado.LixoColetadoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado.LixoColetadoUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.interfaces.CRUDInterface;
import br.com.quatroquatros.gestaoDeResiduos.model.LixoColetado;

public interface LixoColetadoService extends CRUDInterface<LixoColetado, Long, LixoColetadoCadastroDto, LixoColetadoUpdateDto, LixoColetadoExibicaoDto> {
}
