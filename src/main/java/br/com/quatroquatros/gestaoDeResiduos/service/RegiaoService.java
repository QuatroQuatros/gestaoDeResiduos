package br.com.quatroquatros.gestaoDeResiduos.service;

import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.interfaces.CRUDInterface;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;

public interface RegiaoService extends CRUDInterface<Regiao, Long, RegiaoCadastroDto, RegiaoUpdateDto, RegiaoExibicaoDto> {
}
