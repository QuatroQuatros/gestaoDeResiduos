package br.com.quatroquatros.gestaoDeResiduos.dto.auth;

import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;

public record LoginResponseDto(

        UsuarioExibicaoDto usuario,
        String token
) {

}
