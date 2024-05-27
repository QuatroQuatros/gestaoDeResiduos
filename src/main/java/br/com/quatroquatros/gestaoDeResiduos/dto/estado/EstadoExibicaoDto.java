package br.com.quatroquatros.gestaoDeResiduos.dto.estado;

import br.com.quatroquatros.gestaoDeResiduos.model.Estado;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public record EstadoExibicaoDto(
        Long id,
        String nome,
        String uf,

        LocalDateTime createdAt,

        LocalDateTime updateAt
) {

    public EstadoExibicaoDto(Estado estado) {
        this(
                estado.getId(),
                estado.getNome(),
                estado.getUf(),
                estado.getCreatedAt(),
                estado.getUpdatedAt()
        );

    }
}
