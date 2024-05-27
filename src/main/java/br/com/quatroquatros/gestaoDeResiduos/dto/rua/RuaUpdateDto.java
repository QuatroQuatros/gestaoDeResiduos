package br.com.quatroquatros.gestaoDeResiduos.dto.rua;

import jakarta.validation.constraints.NotBlank;

public record RuaUpdateDto(
        @NotBlank(message = "O nome da rua é obrigatório!")
        String nome
) {
}
