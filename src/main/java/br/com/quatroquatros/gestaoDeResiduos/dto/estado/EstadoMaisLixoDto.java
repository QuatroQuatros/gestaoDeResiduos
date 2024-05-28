package br.com.quatroquatros.gestaoDeResiduos.dto.estado;


import br.com.quatroquatros.gestaoDeResiduos.model.ColetaRua;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import br.com.quatroquatros.gestaoDeResiduos.model.TipoColeta;
import br.com.quatroquatros.gestaoDeResiduos.validators.Exists;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EstadoMaisLixoDto(

        @Exists(entity = Estado.class, message = "O id do estado não existe!")
        Long estadoId,

        @Exists(entity = TipoColeta.class, message = "O id do tipo da coleta não existe!")
        Long tipoColetaId


) {
}
