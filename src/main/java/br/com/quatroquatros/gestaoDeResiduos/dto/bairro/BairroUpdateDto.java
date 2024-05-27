package br.com.quatroquatros.gestaoDeResiduos.dto.bairro;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.Exists;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BairroUpdateDto(

        @Exists(entity = Regiao.class, message = "O id da região não existe!")
        Long regiaoId,
        @NotBlank(message = "O nome do bairro é obrigatório!")
        String nome
) {
}
