package br.com.quatroquatros.gestaoDeResiduos.dto.estado;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EstadoUpdateDto(
        @NotBlank(message = "O nome do estado é obrigatório!")
        String nome,

        @NotBlank(message = "A UF do estado é obrigatória!")
        @Size(min = 2, max=2, message = "A UF deve conter 2 caracteres")
        String uf
) {
}
