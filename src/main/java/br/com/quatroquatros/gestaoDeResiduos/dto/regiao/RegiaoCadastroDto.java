package br.com.quatroquatros.gestaoDeResiduos.dto.regiao;

import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegiaoCadastroDto(

        Long id,

        @NotNull(message = "O id do estado da região é obrigatório!")
        Long estadoId,

        @NotBlank(message = "O nome da região é obrigatória!")
        String nome

) {
}
