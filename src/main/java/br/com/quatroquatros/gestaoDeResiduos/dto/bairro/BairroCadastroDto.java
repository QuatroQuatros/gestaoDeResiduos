package br.com.quatroquatros.gestaoDeResiduos.dto.bairro;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.Exists;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BairroCadastroDto (

        @NotNull(message = "O id da região é obrigatório!")
        @Exists(entity = Regiao.class, message = "O id da região não existe!")
        Long regiaoId,

        @NotBlank(message = "O nome do bairro é obrigatório!")
        String nome
){
}
