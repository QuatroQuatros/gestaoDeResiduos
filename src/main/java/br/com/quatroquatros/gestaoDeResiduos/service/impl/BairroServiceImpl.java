package br.com.quatroquatros.gestaoDeResiduos.service.impl;

import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.BairroCadastroDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.BairroExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.bairro.BairroUpdateDto;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;
import br.com.quatroquatros.gestaoDeResiduos.repository.BairroRepository;
import br.com.quatroquatros.gestaoDeResiduos.service.BairroService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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

//        if (bairroRepository.existsByUf(bairroDados.uf())) {
//            throw new DataIntegrityViolationException("já existe um estado cadastrado com a UF fornecida.");
//        }
//        bairro.setUf(estadoDados.uf());
    }
}
