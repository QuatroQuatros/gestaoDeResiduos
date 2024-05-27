package br.com.quatroquatros.gestaoDeResiduos.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginDto(

        @NotBlank(message = "O email do usuário é obrigatório!")
        @Email(message = "O email fornecido não é válido!")
        String email,

        @NotBlank(message = "A senha do usuário é obrigatória!")
        @Size(min = 6, message = "A senha deve conter no minímo 6 caracteres")
        String senha
) {
}

