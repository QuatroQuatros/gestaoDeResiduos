package br.com.quatroquatros.gestaoDeResiduos.service;

import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.interfaces.CRUDInterface;
import br.com.quatroquatros.gestaoDeResiduos.model.Rua;

public interface RuaService extends CRUDInterface<Rua, Long, RuaCadastroDto, RuaUpdateDto, RuaExibicaoDto> {
}
