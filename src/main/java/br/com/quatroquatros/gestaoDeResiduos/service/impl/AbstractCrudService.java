package br.com.quatroquatros.gestaoDeResiduos.service.impl;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.interfaces.CRUDInterface;
import br.com.quatroquatros.gestaoDeResiduos.service.auth.AuthService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class AbstractCrudService<T, ID, Dto, UpdateDto, ExibicaoDto> implements CRUDInterface<T, ID, Dto, UpdateDto, ExibicaoDto>{

    protected abstract JpaRepository<T, ID> getRepository();

    protected abstract ExibicaoDto toExibicaoDto(T entity);

    protected abstract T toEntity(Dto dto);

    protected abstract T updateEntity(T existingEntity, UpdateDto updateDto);

    @Override
    public Page<ExibicaoDto> listarTodos(Pageable paginacao) {
        return getRepository().findAll(paginacao).map(this::toExibicaoDto);
    }

    @Override

    public ExibicaoDto buscarPorId(ID id) throws ModelNotFoundException {
        Optional<T> entityOptional = getRepository().findById(id);
        if (entityOptional.isPresent()) {
            return toExibicaoDto(entityOptional.get());
        } else {
            throw new ModelNotFoundException("entidade não encontrada");
        }
    }

    @Transactional
    @Override
    public ExibicaoDto gravar(Dto dto) {
        T entity = toEntity(dto);
        return toExibicaoDto(getRepository().save(entity));
    }

    @Transactional
    @Override
    public ExibicaoDto atualizar(ID id, UpdateDto updateDto) throws ModelNotFoundException {
        Optional<T> entityOptional = getRepository().findById(id);
        if (entityOptional.isPresent()) {
            T updatedEntity = updateEntity(entityOptional.get(), updateDto);
            return toExibicaoDto(getRepository().save(updatedEntity));

        } else {
            throw new ModelNotFoundException("entidade não encontrada");
        }
    }

    @Transactional
    @Override
    public void excluir(ID id) {
        if (!getRepository().existsById(id)) {
            throw new ModelNotFoundException("entidade não encontrada");
        }
        getRepository().deleteById(id);
    }
}
