package br.com.quatroquatros.gestaoDeResiduos.dto.usuario;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import br.com.quatroquatros.gestaoDeResiduos.model.UsuarioRole;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record UsuarioExibicaoDto(
        Long id,
        String nome,
        String email,
        UsuarioRole role,

        LocalDateTime created_at,

        LocalDateTime  update_at
) {

    public UsuarioExibicaoDto(Usuario usuario){
        this(
                usuario.getUsuarioId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getRole(),
                usuario.getCreatedAt(),
                usuario.getUpdatedAt()
        );
    }

    public BaseResponseDto<UsuarioExibicaoDto> toResponseDto() {
        return new BaseResponseDto<>("busca realizada com sucesso", this);
    }

}
