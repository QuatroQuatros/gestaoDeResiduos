package br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.Exists;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;
import br.com.quatroquatros.gestaoDeResiduos.model.Rua;
import br.com.quatroquatros.gestaoDeResiduos.model.TipoColeta;
import br.com.quatroquatros.gestaoDeResiduos.model.valueObject.ColetaDiaStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


@JsonInclude(JsonInclude.Include.NON_NULL)
public record ColetaRuaUpdateDto(


        @Exists(entity = Rua.class, message = "O id da rua não existe!")
        Long ruaId,

        @Exists(entity = TipoColeta.class, message = "O id do tipo de coleta não existe!")
        Long tipoColetaId,


        LocalDate dataAgendamento,


        LocalDate dataColeta,

        ColetaDiaStatus status
) {
}
