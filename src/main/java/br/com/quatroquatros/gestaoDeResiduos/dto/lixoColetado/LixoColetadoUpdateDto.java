package br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado;


import jakarta.validation.constraints.NotNull;

public record LixoColetadoUpdateDto(

        @NotNull(message = "A quantidade é obrigatória!")
        Double quantidade
) {
}
