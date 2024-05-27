package br.com.quatroquatros.gestaoDeResiduos.service.impl;



import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua.ColetaRuaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.model.ColetaRua;
import br.com.quatroquatros.gestaoDeResiduos.model.valueObject.ColetaDiaStatus;
import br.com.quatroquatros.gestaoDeResiduos.repository.ColetaRuaRepository;
import br.com.quatroquatros.gestaoDeResiduos.service.ColetaRuaService;
import br.com.quatroquatros.gestaoDeResiduos.helpers.AuthHelpers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ColetaRuaServiceImpl extends AbstractCrudService<ColetaRua, Long, ColetaRuaCadastroDto, ColetaRuaUpdateDto, ColetaRuaExibicaoDto> implements ColetaRuaService {


    @Autowired
    private ColetaRuaRepository coletaRuaRepository;
    @Override
    protected JpaRepository<ColetaRua, Long> getRepository() {
        return coletaRuaRepository;
    }

    @Override
    protected ColetaRuaExibicaoDto toExibicaoDto(ColetaRua coletaRua) {
        return new ColetaRuaExibicaoDto(coletaRua);
    }

    @Override
    protected ColetaRua toEntity(ColetaRuaCadastroDto coletaRuaDados) {
        ColetaRua coletaRua = new ColetaRua();
        BeanUtils.copyProperties(coletaRuaDados, coletaRua);
        return coletaRua;
    }

    @Override
    protected ColetaRua updateEntity(ColetaRua coletaRua, ColetaRuaUpdateDto coletaRuaDados) {
        coletaRua.setRuaId(coletaRuaDados.ruaId() != null ? coletaRuaDados.ruaId() : coletaRua.getRuaId());;
        coletaRua.setTipoColetaId(coletaRuaDados.tipoColetaId() != null ? coletaRuaDados.tipoColetaId() : coletaRua.getTipoColetaId());
        coletaRua.setDataAgendamento(coletaRuaDados.dataAgendamento() != null ? coletaRuaDados.dataAgendamento() : coletaRua.getDataAgendamento());
        coletaRua.setDataColeta(coletaRuaDados.dataColeta() != null ? coletaRuaDados.dataColeta() : coletaRua.getDataColeta());
        coletaRua.setStatus(coletaRuaDados.status()!= null ? coletaRuaDados.status() : coletaRua.getStatus());
        return coletaRua;
    }

    @Override
    public ColetaRuaExibicaoDto gravar(ColetaRuaCadastroDto coletaRuaDados) {
        ColetaRua coletaRua = toEntity(coletaRuaDados);

        AuthHelpers authHelpers = new AuthHelpers();

        coletaRua.setUsuarioSolicitanteId(authHelpers.recuperarIdUsuario());
        coletaRua.setRuaId(coletaRuaDados.ruaId());
        coletaRua.setTipoColetaId(coletaRuaDados.tipoColetaId());
        coletaRua.setDataAgendamento(LocalDate.now());
        coletaRua.setStatus(ColetaDiaStatus.PENDENTE);

        return toExibicaoDto(getRepository().save(coletaRua));
    }

}
