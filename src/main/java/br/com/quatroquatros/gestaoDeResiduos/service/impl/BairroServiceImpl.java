package br.com.quatroquatros.gestaoDeResiduos.service.impl;

import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.*;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;
import br.com.quatroquatros.gestaoDeResiduos.repository.BairroRepository;
import br.com.quatroquatros.gestaoDeResiduos.service.BairroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BairroServiceImpl extends AbstractCrudService<Bairro, Long, BairroCadastroDto, BairroUpdateDto, BairroExibicaoDto> implements BairroService {

    @Autowired
    private BairroRepository bairroRepository;
    @Override
    protected JpaRepository<Bairro, Long> getRepository() {
        return bairroRepository;
    }

    @Override
    protected BairroExibicaoDto toExibicaoDto(Bairro bairro) {
        return new BairroExibicaoDto(bairro);
    }

    @Override
    protected Bairro toEntity(BairroCadastroDto bairroDados) {
        Bairro bairro = new Bairro();
        BeanUtils.copyProperties(bairroDados, bairro);
        return bairro;
    }

    @Override
    protected Bairro updateEntity(Bairro bairro, BairroUpdateDto bairroDados) {
        bairro.setNome(bairroDados.nome());
        return bairro;

    }

    @Override
    public List<BairroMaisLixoExibicaoDto[]> bairroMaisLixo(BairroMaisLixoDto bairroMaisLixoDto) {
        List<BairroMaisLixoExibicaoDto[]> bairros = new ArrayList<>();

        List<Object[]> queryResult = bairroRepository.bairroMaisLixo(
                bairroMaisLixoDto.bairroId(),
                bairroMaisLixoDto.tipoColetaId()
        );
        for (Object[] row : queryResult) {
            Double quantidade = (Double) row[0];
            String bairro = (String) row[1];
            String tipoLixo = (String) row[2];
            bairros.add(new BairroMaisLixoExibicaoDto[]{new BairroMaisLixoExibicaoDto(quantidade, bairro, tipoLixo)});
        }
        return bairros;
    }
}
