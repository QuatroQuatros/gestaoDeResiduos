package br.com.quatroquatros.gestaoDeResiduos.dto.bairro;

import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;
import br.com.quatroquatros.gestaoDeResiduos.model.TipoColeta;
import br.com.quatroquatros.gestaoDeResiduos.validators.Exists;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record BairroMaisLixoDto(
        @Exists(entity = Bairro.class, message = "O id do bairro não existe!")
        Long bairroId,

        @Exists(entity = TipoColeta.class, message = "O id do tipo da coleta não existe!")
        Long tipoColetaId
) {
}
