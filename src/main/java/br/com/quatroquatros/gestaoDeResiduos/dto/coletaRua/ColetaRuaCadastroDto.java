package br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.Exists;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;
import br.com.quatroquatros.gestaoDeResiduos.model.Rua;
import br.com.quatroquatros.gestaoDeResiduos.model.TipoColeta;
import br.com.quatroquatros.gestaoDeResiduos.model.valueObject.ColetaDiaStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record ColetaRuaCadastroDto(

        Long usuarioSolicitanteId,

        @NotNull(message = "O id a rua é obrigatório!")
        @Exists(entity = Rua.class, message = "O id da rua não existe!")
        Long ruaId,
        @NotNull(message = "O id do tipo de coleta é obrigatório!")
        @Exists(entity = TipoColeta.class, message = "O id do tipo da coleta não existe!")
        Long tipoColetaId,

        LocalDate dataAgendamento,

        LocalDate dataColeta,

        ColetaDiaStatus status
) {
}
