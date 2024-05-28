package br.com.quatroquatros.gestaoDeResiduos.dto.regiao;

import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;
import br.com.quatroquatros.gestaoDeResiduos.model.TipoColeta;
import br.com.quatroquatros.gestaoDeResiduos.validators.Exists;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record RegiaoMaisLixoDto(
        @Exists(entity = Regiao.class, message = "O id da região não existe!")
        Long regiaoId,

        @Exists(entity = TipoColeta.class, message = "O id do tipo da coleta não existe!")
        Long tipoColetaId

) {
}
