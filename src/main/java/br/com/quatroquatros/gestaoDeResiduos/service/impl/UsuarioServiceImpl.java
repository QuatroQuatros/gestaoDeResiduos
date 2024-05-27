package br.com.quatroquatros.gestaoDeResiduos.service.impl;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;
import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import br.com.quatroquatros.gestaoDeResiduos.repository.UsuarioRepository;
import br.com.quatroquatros.gestaoDeResiduos.service.UsuarioService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UsuarioServiceImpl extends AbstractCrudService<Usuario, Long, UsuarioCadastroDto, UsuarioUpdateDto, UsuarioExibicaoDto> implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected JpaRepository<Usuario, Long> getRepository() {
        return usuarioRepository;
    }

    @Override
    protected UsuarioExibicaoDto toExibicaoDto(Usuario usuario) {
        return new UsuarioExibicaoDto(usuario);
    }

    @Override
    protected Usuario toEntity(UsuarioCadastroDto usuarioCadastroDto) {
        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioCadastroDto, usuario);

        return usuario;
    }

    @Override
    protected Usuario updateEntity(Usuario usuario, UsuarioUpdateDto usuarioDados) {
        usuario.setNome(usuarioDados.nome());
        usuario.setEmail(usuarioDados.email());
        return usuario;
    }

    @Override
    public UsuarioExibicaoDto gravar(UsuarioCadastroDto usuarioDados){
        String senhaHash = new BCryptPasswordEncoder().encode(usuarioDados.senha());

        Usuario usuario = new Usuario();
        BeanUtils.copyProperties(usuarioDados, usuario);
        usuario.setSenha(senhaHash);

        return new UsuarioExibicaoDto(usuarioRepository.save(usuario));
    }


}
