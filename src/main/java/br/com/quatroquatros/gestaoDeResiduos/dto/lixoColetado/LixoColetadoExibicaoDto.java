package br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado;

import br.com.quatroquatros.gestaoDeResiduos.model.LixoColetado;

import java.time.LocalDateTime;

public record LixoColetadoExibicaoDto(
        Long id,
        Long coletaRuaId,
        Double quantidade,

        LocalDateTime createdAt,

        LocalDateTime updateAt
) {

    public LixoColetadoExibicaoDto(LixoColetado lixoColetado){
         this(
                lixoColetado.getId(),
                lixoColetado.getColetaRuaId(),
                lixoColetado.getQuantidade(),
                lixoColetado.getCreatedAt(),
                lixoColetado.getUpdatedAt()
        );
    }
}
