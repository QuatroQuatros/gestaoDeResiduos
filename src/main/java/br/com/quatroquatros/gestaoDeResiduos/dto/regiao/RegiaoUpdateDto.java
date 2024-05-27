package br.com.quatroquatros.gestaoDeResiduos.dto.regiao;

import br.com.quatroquatros.gestaoDeResiduos.validators.Exists;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public record RegiaoUpdateDto(

        @Exists(entity = Estado.class, message = "O id da região não existe!")
        Long estadoId,

        String nome
) {
}
