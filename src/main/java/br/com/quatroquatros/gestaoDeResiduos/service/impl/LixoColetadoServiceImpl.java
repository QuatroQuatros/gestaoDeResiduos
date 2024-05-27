package br.com.quatroquatros.gestaoDeResiduos.service.impl;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado.LixoColetadoCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado.LixoColetadoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado.LixoColetadoUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.model.LixoColetado;
import br.com.quatroquatros.gestaoDeResiduos.repository.LixoColetadoRepository;
import br.com.quatroquatros.gestaoDeResiduos.service.LixoColetadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LixoColetadoServiceImpl extends AbstractCrudService<LixoColetado, Long, LixoColetadoCadastroDto, LixoColetadoUpdateDto, LixoColetadoExibicaoDto> implements LixoColetadoService {

    @Autowired
    private LixoColetadoRepository lixoColetadoRepository;

    @Override
    protected JpaRepository<LixoColetado, Long> getRepository() {
        return lixoColetadoRepository;
    }

    @Override
    protected LixoColetadoExibicaoDto toExibicaoDto(LixoColetado lixoColetado) {
        return new LixoColetadoExibicaoDto(lixoColetado);
    }

    @Override
    protected LixoColetado toEntity(LixoColetadoCadastroDto lixoColetadoDados) {
        LixoColetado lixoColetado = new LixoColetado();
        BeanUtils.copyProperties(lixoColetadoDados, lixoColetado);
        return lixoColetado;
    }

    @Override
    protected LixoColetado updateEntity(LixoColetado lixoColetado, LixoColetadoUpdateDto lixoColetadoDados) {
        lixoColetado.setQuantidade(lixoColetadoDados.quantidade());
        return lixoColetado;

    }
}
