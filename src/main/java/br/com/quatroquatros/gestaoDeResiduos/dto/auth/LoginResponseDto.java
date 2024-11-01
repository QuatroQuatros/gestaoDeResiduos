package br.com.quatroquatros.gestaoDeResiduos.dto.auth;



import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioExibicaoDto;


public record LoginResponseDto(

        UsuarioExibicaoDto usuario,
        String token
) {

}
