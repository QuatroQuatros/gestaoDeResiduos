package br.com.quatroquatros.gestaoDeResiduos.dto.regiao;

import jakarta.validation.constraints.NotBlank;

public record RegiaoUpdateDto(
        @NotBlank(message = "O nome da região é obrigatória!")
        String nome
) {
}
