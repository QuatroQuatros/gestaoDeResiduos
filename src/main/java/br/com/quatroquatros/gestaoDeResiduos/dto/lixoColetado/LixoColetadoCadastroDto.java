package br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record LixoColetadoCadastroDto(

        @NotNull(message = "O id da coleta é obrigatório!")
        Long coletaRuaId,

        @NotNull(message = "A quantidade é obrigatória!")
        Double quantidade

) {
}
