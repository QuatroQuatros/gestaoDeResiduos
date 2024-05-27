package br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua;

import br.com.quatroquatros.gestaoDeResiduos.model.valueObject.ColetaDiaStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ColetaRuaCadastroDto(

        //@NotNull(message = "O id do usuário solicitante é obrigatório!")
        Long usuarioSolicitanteId,

        @NotNull(message = "O id a rua é obrigatório!")
        Long ruaId,
        @NotNull(message = "O id do tipo de coleta é obrigatório!")
        Long tipoColetaId,

        //@NotNull(message = "A data do agendamento é obrigatória!")
        LocalDate dataAgendamento,

        //@NotNull(message = "A data de coleta é obrigatória!")
        LocalDate dataColeta,

        ColetaDiaStatus status
) {
}
