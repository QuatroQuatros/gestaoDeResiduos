package br.com.quatroquatros.gestaoDeResiduos.dto.rua;

import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;
import br.com.quatroquatros.gestaoDeResiduos.model.Rua;

import java.time.LocalDateTime;

public record RuaExibicaoDto(
        Long id,
        String nome,

        Long bairroId,

        LocalDateTime createdAt,

        LocalDateTime updateAt

) {

    public RuaExibicaoDto(Rua rua) {
        this(
                rua.getId(),
                rua.getNome(),
                rua.getBairroId(),
                rua.getCreatedAt(),
                rua.getUpdatedAt()
        );

    }

}
