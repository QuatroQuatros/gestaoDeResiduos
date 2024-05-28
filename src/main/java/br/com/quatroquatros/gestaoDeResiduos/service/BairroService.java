package br.com.quatroquatros.gestaoDeResiduos.service;

import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.*;
import br.com.quatroquatros.gestaoDeResiduos.interfaces.CRUDInterface;
import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;

import java.util.List;


public interface BairroService extends CRUDInterface<Bairro, Long, BairroCadastroDto, BairroUpdateDto, BairroExibicaoDto> {
    List<BairroMaisLixoExibicaoDto[]> bairroMaisLixo(BairroMaisLixoDto bairroMaisLixoDto);

}
