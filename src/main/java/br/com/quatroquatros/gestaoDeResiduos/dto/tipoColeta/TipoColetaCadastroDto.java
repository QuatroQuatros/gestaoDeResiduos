package br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TipoColetaCadastroDto (
        Long id,
        @NotBlank(message = "A descrição do tipo de coleta é obrigatória!")
        String descricao
){
}
