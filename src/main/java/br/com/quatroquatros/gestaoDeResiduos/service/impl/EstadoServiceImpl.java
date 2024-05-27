package br.com.quatroquatros.gestaoDeResiduos.service.impl;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.usuario.UsuarioUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;
import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import br.com.quatroquatros.gestaoDeResiduos.repository.EstadoRepository;
import br.com.quatroquatros.gestaoDeResiduos.service.EstadoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EstadoServiceImpl extends AbstractCrudService<Estado, Long, EstadoCadastroDto, EstadoUpdateDto, EstadoExibicaoDto> implements EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    protected JpaRepository<Estado, Long> getRepository() {
        return estadoRepository;
    }

    @Override
    protected EstadoExibicaoDto toExibicaoDto(Estado estado) {
        return new EstadoExibicaoDto(estado);
    }

    @Override
    protected Estado toEntity(EstadoCadastroDto estadoCadastroDto) {
        Estado estado = new Estado();
        BeanUtils.copyProperties(estadoCadastroDto, estado);
        return estado;
    }

    @Override
    protected Estado updateEntity(Estado estado, EstadoUpdateDto estadoDados) {
        estado.setNome(estadoDados.nome());
        if (estadoRepository.existsByUf(estadoDados.uf())) {
            throw new DataIntegrityViolationException("já existe um estado cadastrado com a UF fornecida.");
        }
        estado.setUf(estadoDados.uf());
        return estado;

    }

    @Override
    public BaseResponseDto<EstadoExibicaoDto> buscarEstadoPorUF(String uf) {
        Optional<Estado> estadoOptional = estadoRepository.findByUf(uf);
        if (estadoOptional.isPresent()) {
            return new BaseResponseDto<>(
                    "busca de estado pela UF feita com sucesso!",
                    new EstadoExibicaoDto(estadoOptional.get())
            );
        } else {
            throw new ModelNotFoundException("estado não encontrado");
        }
    }

//    @Override
//    public Page<EstadoExibicaoDto> listarTodos(Pageable paginacao) {
//        return estadoRepository.findAll(paginacao).map(EstadoExibicaoDto::new);
//
//    }
//
//public EstadoExibicaoDto buscarPorId(Long id){
//        Optional<Estado> estadoOptional = estadoRepository.findById(id);
//        if (estadoOptional.isPresent()) {
//            return new EstadoExibicaoDto(estadoOptional.get());
//        } else {
//            throw new ModelNotFoundException("estado não encontrado");
//        }
//    }
//
//    public EstadoExibicaoDto gravar(EstadoCadastroDto estadoDados){
//
//        if (estadoRepository.existsByUf(estadoDados.uf())) {
//            throw new DataIntegrityViolationException("já existe um estado cadastrado com a UF fornecida.");
//        }
//
//        Estado estado = new Estado();
//        BeanUtils.copyProperties(estadoDados, estado);
//        estado.setCreatedAt(LocalDateTime.now());
//        return new EstadoExibicaoDto(estadoRepository.save(estado));
//    }
//
//    public BaseResponseDto<EstadoExibicaoDto> atualizar(Long id, EstadoCadastroDto estadoDados){
//        Optional<Estado> estadoOptional = estadoRepository.findById(id);
//        if (estadoOptional.isPresent()) {
//            Estado estadoExistente = estadoOptional.get();
//            estadoExistente.setNome(estadoDados.nome());
//            estadoExistente.setUf(estadoDados.uf());
//            estadoExistente.setUpdatedAt(LocalDateTime.now());
//            return new BaseResponseDto<>(
//                    "estado atualizado com sucesso!",
//                    new EstadoExibicaoDto(estadoRepository.save(estadoExistente))
//            );
//        } else {
//            throw new ModelNotFoundException("estado não encontrado");
//        }
//    }
//
//    public BaseResponseDto<EstadoExibicaoDto> excluir(Long id) {
//        Optional<Estado> estadoOptional = estadoRepository.findById(id);
//        if (estadoOptional.isPresent()) {
//            estadoRepository.delete(estadoOptional.get());
//            return new BaseResponseDto<>(
//                    "estado deletado com sucesso!"
//            );
//        } else {
//            throw new ModelNotFoundException("estado não encontrado");
//        }
//    }
//

}
