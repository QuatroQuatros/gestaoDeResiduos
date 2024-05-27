package br.com.quatroquatros.gestaoDeResiduos.interfaces;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CRUDInterface<T, ID, CadastroDto, AtualizacaoDto, ExibicaoDto> {

   Page<ExibicaoDto> listarTodos(Pageable paginacao);

    ExibicaoDto buscarPorId(ID id) throws ModelNotFoundException;

    ExibicaoDto gravar(CadastroDto dto);
    ExibicaoDto atualizar(ID id, AtualizacaoDto dto) throws ModelNotFoundException;
    void excluir(ID id) throws ModelNotFoundException;
}
