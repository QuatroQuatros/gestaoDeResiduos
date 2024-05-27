package br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado;

import br.com.quatroquatros.gestaoDeResiduos.dto.validations.Exists;
import br.com.quatroquatros.gestaoDeResiduos.model.ColetaRua;
import jakarta.validation.constraints.NotNull;

public record LixoColetadoCadastroDto(

        @NotNull(message = "O id da coleta é obrigatório!")
        @Exists(entity = ColetaRua.class, message = "O id da coleta não existe!")
        Long coletaRuaId,

        @NotNull(message = "A quantidade é obrigatória!")
        Double quantidade

) {
}
