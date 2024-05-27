package br.com.quatroquatros.gestaoDeResiduos.dto.bairro;

import jakarta.validation.constraints.NotBlank;

public record BairroUpdateDto(
        @NotBlank(message = "O nome do bairro é obrigatório!")
        String nome
) {
}
