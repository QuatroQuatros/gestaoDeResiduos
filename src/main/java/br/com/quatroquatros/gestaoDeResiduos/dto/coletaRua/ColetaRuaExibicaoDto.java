package br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua;

import br.com.quatroquatros.gestaoDeResiduos.model.ColetaRua;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import br.com.quatroquatros.gestaoDeResiduos.model.valueObject.ColetaDiaStatus;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ColetaRuaExibicaoDto(

        Long id,
        Long usuarioSolicitanteId,

        Long ruaId,
        Long tipoColetaId,

        LocalDate dataAgendamento,

        LocalDate dataColeta,

        ColetaDiaStatus status,

        LocalDateTime createdAt,

        LocalDateTime updateAt
) {

    public ColetaRuaExibicaoDto(ColetaRua coletaRua) {
        this(
                coletaRua.getId(),
                coletaRua.getUsuarioSolicitanteId(),
                coletaRua.getRuaId(),
                coletaRua.getTipoColetaId(),
                coletaRua.getDataAgendamento(),
                coletaRua.getDataColeta(),
                coletaRua.getStatus(),
                coletaRua.getCreatedAt(),
                coletaRua.getUpdatedAt()
        );

    }
}
