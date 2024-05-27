package br.com.quatroquatros.gestaoDeResiduos.service;

import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.BairroCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.BairroExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.BairroUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.interfaces.CRUDInterface;
import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;


public interface BairroService extends CRUDInterface<Bairro, Long, BairroCadastroDto, BairroUpdateDto, BairroExibicaoDto> {
}
