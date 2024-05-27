package br.com.quatroquatros.gestaoDeResiduos.dto.usuario;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UsuarioUpdateDto(

        @NotBlank(message = "O nome do usuário é obrigatório!")
        String nome,

        @NotBlank(message = "O email do usuário é obrigatório!")
        @Email(message = "O email fornecido não é válido!")
        String email
) {
}
