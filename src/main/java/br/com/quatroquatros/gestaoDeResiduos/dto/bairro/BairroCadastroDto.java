package br.com.quatroquatros.gestaoDeResiduos.dto.bairro;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BairroCadastroDto (
        Long id,

        @NotNull(message = "O id da região é obrigatório!")
        Long regiaoId,

        @NotBlank(message = "O nome do bairro é obrigatório!")
        String nome
){
}
