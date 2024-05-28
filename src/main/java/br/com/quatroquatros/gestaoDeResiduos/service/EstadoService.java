package br.com.quatroquatros.gestaoDeResiduos.service;


import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.*;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.interfaces.CRUDInterface;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EstadoService extends CRUDInterface<Estado, Long, EstadoCadastroDto, EstadoUpdateDto, EstadoExibicaoDto> {
    EstadoExibicaoDto buscarEstadoPorUF(String uf) throws ModelNotFoundException;

    List<EstadoMaisLixoExibicaoDto[]> estadoMaisLixo(EstadoMaisLixoDto estadoMaisLixoDto);
}
