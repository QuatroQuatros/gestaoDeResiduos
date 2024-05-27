package br.com.quatroquatros.gestaoDeResiduos.dto.lixoColetado;


import br.com.quatroquatros.gestaoDeResiduos.dto.validations.Exists;
import br.com.quatroquatros.gestaoDeResiduos.model.ColetaRua;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record LixoColetadoUpdateDto(

        @Exists(entity = ColetaRua.class, message = "O id da coleta não existe!")
        Long coletaRuaId,

        Double quantidade
) {
}
