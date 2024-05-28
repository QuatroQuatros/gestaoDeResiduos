package br.com.quatroquatros.gestaoDeResiduos.service.impl;

import br.com.quatroquatros.gestaoDeResiduos.dto.BaseResponseDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.*;
import br.com.quatroquatros.gestaoDeResiduos.exception.ModelNotFoundException;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;
import br.com.quatroquatros.gestaoDeResiduos.repository.EstadoRepository;
import br.com.quatroquatros.gestaoDeResiduos.repository.RegiaoRepository;
import br.com.quatroquatros.gestaoDeResiduos.service.RegiaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RegiaoServiceImpl extends AbstractCrudService<Regiao, Long, RegiaoCadastroDto, RegiaoUpdateDto, RegiaoExibicaoDto> implements RegiaoService  {

    @Autowired
    private RegiaoRepository regiaoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    protected JpaRepository<Regiao, Long> getRepository() {
        return regiaoRepository;
    }

    @Override
    protected RegiaoExibicaoDto toExibicaoDto(Regiao regiao) {
        return new RegiaoExibicaoDto(regiao);
    }

    @Override
    protected Regiao toEntity(RegiaoCadastroDto regiaoDados) {
        Regiao regiao = new Regiao();
        BeanUtils.copyProperties(regiaoDados, regiao);

        Optional<Estado> estadoOptional = estadoRepository.findById(regiaoDados.estadoId());
        if (estadoOptional.isPresent()) {
            regiao.setEstado(estadoOptional.get());
        } else {
            throw new ModelNotFoundException("estado não encontrado");
        }

        return regiao;
    }

    @Override
    protected Regiao updateEntity(Regiao regiao, RegiaoUpdateDto regiaoDados) {
        regiao.setNome(regiaoDados.nome());
        regiao.setUpdatedAt(LocalDateTime.now());
        return regiao;
    }

    @Override
    public List<RegiaoMaisLixoExibicaoDto[]> regiaoMaisLixo(RegiaoMaisLixoDto regiaoMaisLixoDto) {
        List<RegiaoMaisLixoExibicaoDto[]> regioes = new ArrayList<>();

        List<Object[]> queryResult = regiaoRepository.regiaoMaisLixo(
                regiaoMaisLixoDto.regiaoId(),
                regiaoMaisLixoDto.tipoColetaId()
        );
        for (Object[] row : queryResult) {
            Double quantidade = (Double) row[0];
            String regiao = (String) row[1];
            String tipoLixo = (String) row[2];
            regioes.add(new RegiaoMaisLixoExibicaoDto[]{new RegiaoMaisLixoExibicaoDto(quantidade, regiao, tipoLixo)});
        }
        return regioes;
    }

}
