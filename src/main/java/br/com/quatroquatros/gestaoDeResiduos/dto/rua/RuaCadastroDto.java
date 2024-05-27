package br.com.quatroquatros.gestaoDeResiduos.dto.rua;

import br.com.quatroquatros.gestaoDeResiduos.validators.Exists;
import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RuaCadastroDto (
        @NotNull(message = "O id da rua é obrigatório!")
        @Exists(entity = Bairro.class, message = "O id do bairro não existe!")
        Long bairroId,

        @NotBlank(message = "O nome da rua é obrigatório!")
        String nome
){
}
