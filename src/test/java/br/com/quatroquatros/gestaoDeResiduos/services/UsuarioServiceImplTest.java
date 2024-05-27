package br.com.quatroquatros.gestaoDeResiduos.services;


import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import br.com.quatroquatros.gestaoDeResiduos.repository.UsuarioRepository;
import br.com.quatroquatros.gestaoDeResiduos.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private Usuario usuarioMock;

    @BeforeEach
    void setUp() {
        usuarioMock = new Usuario();
        usuarioMock.setUsuarioId(1L);
        usuarioMock.setNome("Usuário Teste");
        usuarioMock.setEmail("teste@example.com");
    }

    @Test
    void listarTodosOsUsuarios_deveRetornarListaPaginadaDeUsuarios() {
        List<Usuario> usuarios = List.of(usuarioMock);
        Page<Usuario> pageUsuarios = new PageImpl<>(usuarios);
        when(usuarioRepository.findAll(any(Pageable.class))).thenReturn(pageUsuarios);

        Page<UsuarioExibicaoDto> resultado = usuarioService.listarTodos(Pageable.unpaged());

        assertEquals(1, resultado.getTotalElements());
        assertEquals(1, resultado.getContent().size());
        assertEquals(usuarioMock.getUsuarioId(), resultado.getContent().get(0).id());
        assertEquals(usuarioMock.getNome(), resultado.getContent().get(0).nome());
        assertEquals(usuarioMock.getEmail(), resultado.getContent().get(0).email());


        verify(usuarioRepository, times(1)).findAll(any(Pageable.class));
    }

    @Test
    void buscarUsuarioPorIdDeveRetornarUsuario() {
        usuarioMock.setUsuarioId(1L);
        usuarioMock.setNome("Usuário Teste");
        usuarioMock.setEmail("teste@example.com");
        when(usuarioRepository.findById(usuarioMock.getUsuarioId())).thenReturn(Optional.of(usuarioMock));

//        BaseResponseDto<UsuarioExibicaoDto> response = usuarioService.buscarPorId(usuarioMock.getUsuarioId());//        assertEquals("busca de usuário realizada com sucesso!", response.message());
//        assertEquals(usuarioMock.getUsuarioId(), response.data().id());
//        assertEquals(usuarioMock.getNome(), response.data().nome());
//        assertEquals(usuarioMock.getEmail(), response.data().email());

        UsuarioExibicaoDto response = usuarioService.buscarPorId(usuarioMock.getUsuarioId());

        assertEquals(usuarioMock.getUsuarioId(), response.id());
        assertEquals(usuarioMock.getNome(), response.nome());
        assertEquals(usuarioMock.getEmail(), response.email());


        verify(usuarioRepository, times(1)).findById(usuarioMock.getUsuarioId());

    }

//    @Test
//    void criarUsuarioDeveRetornarEleMesmo() {
//        usuarioMock.setUsuarioId(1L);
//        usuarioMock.setNome("Usuário Teste");
//        usuarioMock.setEmail("teste@example.com");
//        when(usuarioRepository.save(usuarioMock)).thenReturn(usuarioMock);
//
//        UsuarioCadastroDto usuarioDados = new UsuarioCadastroDto(usuarioMock);
//
//        BaseResponseDto<UsuarioExibicaoDto> response = usuarioService.gravar(usuarioMock);
//
//        verify(usuarioRepository, times(1)).save(any(Usuario.class));
//
//        assertEquals("usuário cadastrado com sucesso!", response.message());
//        assertEquals(usuarioMock.getUsuarioId(), response.data().id());
//        assertEquals(usuarioMock.getNome(), response.data().nome());
//        assertEquals(usuarioMock.getEmail(), response.data().email());
//
//    }
}
