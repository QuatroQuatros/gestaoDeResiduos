package br.com.quatroquatros.gestaoDeResiduos.dto.bairro;

import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;

import java.time.LocalDateTime;

public record BairroExibicaoDto(
        Long id,
        String nome,

        Long regiaoId,

        LocalDateTime createdAt,

        LocalDateTime updateAt

        //RegiaoExibicaoDto regiao
) {

    public BairroExibicaoDto(Bairro bairro) {
        this(
                bairro.getId(),
                bairro.getNome(),
                bairro.getRegiaoId(),
                bairro.getCreatedAt(),
                bairro.getUpdatedAt()
                //new RegiaoExibicaoDto(bairro.getRegiao())
        );

    }


}
