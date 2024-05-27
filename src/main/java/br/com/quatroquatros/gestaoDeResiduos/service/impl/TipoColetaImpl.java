package br.com.quatroquatros.gestaoDeResiduos.service.impl;

import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta.TipoColetaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta.TipoColetaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta.TipoColetaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.model.Rua;
import br.com.quatroquatros.gestaoDeResiduos.model.TipoColeta;
import br.com.quatroquatros.gestaoDeResiduos.repository.RuaRepository;
import br.com.quatroquatros.gestaoDeResiduos.repository.TipoColetaRepository;
import br.com.quatroquatros.gestaoDeResiduos.service.TipoColetaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class TipoColetaImpl extends AbstractCrudService<TipoColeta, Long, TipoColetaCadastroDto, TipoColetaUpdateDto, TipoColetaExibicaoDto> implements TipoColetaService {

    @Autowired
    private TipoColetaRepository tipoColetaRepository;

    @Override
    protected JpaRepository<TipoColeta, Long> getRepository() {
        return tipoColetaRepository;
    }

    @Override
    protected TipoColetaExibicaoDto toExibicaoDto(TipoColeta tipoColeta) {
        return new TipoColetaExibicaoDto(tipoColeta);
    }

    @Override
    protected TipoColeta toEntity(TipoColetaCadastroDto tipoColetaDados) {
        TipoColeta tipoColeta = new TipoColeta();
        BeanUtils.copyProperties(tipoColetaDados, tipoColeta);
        return tipoColeta;
    }

    @Override
    protected TipoColeta updateEntity(TipoColeta tipoColeta, TipoColetaUpdateDto tipoColetaDados) {
        tipoColeta.setDescricao(tipoColetaDados.descricao());
        return tipoColeta;
    }
}
