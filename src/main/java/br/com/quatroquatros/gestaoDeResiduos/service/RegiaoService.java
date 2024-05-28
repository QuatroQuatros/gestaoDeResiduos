package br.com.quatroquatros.gestaoDeResiduos.service;

import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.*;
import br.com.quatroquatros.gestaoDeResiduos.interfaces.CRUDInterface;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;

import java.util.List;

public interface RegiaoService extends CRUDInterface<Regiao, Long, RegiaoCadastroDto, RegiaoUpdateDto, RegiaoExibicaoDto> {

     List<RegiaoMaisLixoExibicaoDto[]> regiaoMaisLixo(RegiaoMaisLixoDto regiaoMaisLixoDto);

}
