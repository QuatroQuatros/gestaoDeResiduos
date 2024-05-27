package br.com.quatroquatros.gestaoDeResiduos.dto.regiao;

import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;

import java.time.LocalDateTime;

public record RegiaoExibicaoDto(

        Long id,
        String nome,

        LocalDateTime createdAt,

        LocalDateTime updateAt,

        EstadoExibicaoDto estado
) {

    public RegiaoExibicaoDto(Regiao regiao) {
        this(
                regiao.getId(),
                regiao.getNome(),
                regiao.getCreatedAt(),
                regiao.getUpdatedAt(),
                new EstadoExibicaoDto(regiao.getEstado())
        );

    }
}