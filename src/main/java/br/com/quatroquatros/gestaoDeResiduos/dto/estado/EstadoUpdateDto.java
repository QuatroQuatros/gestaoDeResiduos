package br.com.quatroquatros.gestaoDeResiduos.dto.estado;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


@JsonInclude(JsonInclude.Include.NON_NULL)
public record EstadoUpdateDto(

        String nome,

        @Size(min = 2, max=2, message = "A UF deve conter 2 caracteres")
        String uf
) {
}
