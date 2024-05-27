package br.com.quatroquatros.gestaoDeResiduos.service;


import br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta.TipoColetaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta.TipoColetaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.tipoColeta.TipoColetaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.interfaces.CRUDInterface;
import br.com.quatroquatros.gestaoDeResiduos.model.TipoColeta;

public interface TipoColetaService extends CRUDInterface<TipoColeta, Long, TipoColetaCadastroDto, TipoColetaUpdateDto, TipoColetaExibicaoDto> {
}
