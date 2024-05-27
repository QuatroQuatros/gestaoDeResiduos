package br.com.quatroquatros.gestaoDeResiduos.dto.regiao;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.Exists;
import br.com.quatroquatros.gestaoDeResiduos.model.ColetaRua;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegiaoCadastroDto(

        @NotNull(message = "O id do estado da região é obrigatório!")
        @Exists(entity = Estado.class, message = "O id do estado não existe!")
        Long estadoId,

        @NotBlank(message = "O nome da região é obrigatória!")
        String nome

) {
}
