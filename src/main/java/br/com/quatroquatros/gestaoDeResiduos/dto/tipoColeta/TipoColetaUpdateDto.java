package br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record TipoColetaUpdateDto(
        @NotBlank(message = "A descrição do tipo de coleta é obrigatória!")
        String descricao
) {
}
