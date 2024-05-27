package br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta;

import jakarta.validation.constraints.NotBlank;

public record TipoColetaUpdateDto(
        @NotBlank(message = "A descrição do tipo de coleta é obrigatória!")
        String descricao
) {
}
