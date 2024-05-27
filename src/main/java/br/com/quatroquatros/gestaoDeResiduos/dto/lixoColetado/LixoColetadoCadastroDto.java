package br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.ColetaRuaExiste;
import jakarta.validation.constraints.NotNull;

public record LixoColetadoCadastroDto(

        @NotNull(message = "O id da coleta é obrigatório!")
        @ColetaRuaExiste(message = "O id da coleta não existe!")
        Long coletaRuaId,

        @NotNull(message = "A quantidade é obrigatória!")
        Double quantidade

) {
}
