package br.com.quatroquatros.gestaoDeResiduos.dto.rua;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.Exists;
import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RuaUpdateDto(


        @Exists(entity = Bairro.class, message = "O id da região não existe!")
        Long bairroId,

        String nome
) {
}
