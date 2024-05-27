package br.com.quatroquatros.gestaoDeResiduos.dto.usuario;

import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import br.com.quatroquatros.gestaoDeResiduos.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(

        @NotBlank(message = "O nome do usuário é obrigatório!")
        String nome,

        @NotBlank(message = "O email do usuário é obrigatório!")
        @Email(message = "O email fornecido não é válido!")
        String email,

        @NotBlank(message = "A senha do usuário é obrigatória!")
        @Size(min = 6, message = "A senha deve conter no minímo 6 caracteres")
        String senha,

        UsuarioRole role
) {
}
