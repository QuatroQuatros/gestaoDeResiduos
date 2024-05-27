package br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta;


import br.com.quatroquatros.gestaoDeResiduos.model.TipoColeta;
import java.time.LocalDateTime;

public record TipoColetaExibicaoDto(
        Long id,
        String descricao,

        LocalDateTime createdAt,

        LocalDateTime updateAt

) {

    public TipoColetaExibicaoDto(TipoColeta tipoColeta) {
        this(
                tipoColeta.getId(),
                tipoColeta.getDescricao(),
                tipoColeta.getCreatedAt(),
                tipoColeta.getUpdatedAt()
        );

    }
}
