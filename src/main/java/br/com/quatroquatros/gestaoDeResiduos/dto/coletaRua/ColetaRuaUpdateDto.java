package br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua;

import br.com.quatroquatros.gestaoDeResiduos.model.valueObject.ColetaDiaStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


@JsonInclude(JsonInclude.Include.NON_NULL) // Exclui campos nulos da serialização JSON
public record ColetaRuaUpdateDto(

        Long ruaId,

        Long tipoColetaId,


        LocalDate dataAgendamento,


        LocalDate dataColeta,

        ColetaDiaStatus status
) {
}
