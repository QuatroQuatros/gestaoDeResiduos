package br.com.quatroquatros.gestaoDeResiduos.dto.coletaRua;

import jakarta.validation.constraints.NotNull;

public record ColetaRuaConcluidaDto(
        @NotNull(message = "A quantidade é obrigatória!")
        Double quantidade
) {
}
