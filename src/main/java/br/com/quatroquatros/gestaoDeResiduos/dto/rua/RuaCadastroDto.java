package br.com.quatroquatros.gestaoDeResiduos.dto.rua;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RuaCadastroDto (
        Long id,

        @NotNull(message = "O id da rua é obrigatório!")
        Long bairroId,

        @NotBlank(message = "O nome da rua é obrigatório!")
        String nome
){
}
