package br.com.quatroquatros.gestaoDeResiduos.service.impl;



import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.rua.RuaUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;
import br.com.quatroquatros.gestaoDeResiduos.model.Rua;
import br.com.quatroquatros.gestaoDeResiduos.repository.BairroRepository;
import br.com.quatroquatros.gestaoDeResiduos.repository.RuaRepository;
import br.com.quatroquatros.gestaoDeResiduos.service.RuaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class RuaServiceImpl extends AbstractCrudService<Rua, Long, RuaCadastroDto, RuaUpdateDto, RuaExibicaoDto> implements RuaService {

    @Autowired
    private RuaRepository ruaRepository;

    @Override
    protected JpaRepository<Rua, Long> getRepository() {
        return ruaRepository;
    }

    @Override
    protected RuaExibicaoDto toExibicaoDto(Rua rua) {
        return new RuaExibicaoDto(rua);
    }

    @Override
    protected Rua toEntity(RuaCadastroDto ruaDados) {
        Rua rua = new Rua();
        BeanUtils.copyProperties(ruaDados, rua);
        return rua;
    }

    @Override
    protected Rua updateEntity(Rua rua, RuaUpdateDto ruaDados) {
        rua.setNome(ruaDados.nome());
        return rua;
    }
}
