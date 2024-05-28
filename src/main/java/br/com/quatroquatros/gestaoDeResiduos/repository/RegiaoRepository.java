package br.com.quatroquatros.gestaoDeResiduos.repository;

import br.com.quatroquatros.gestaoDeResiduos.dto.regiao.RegiaoMaisLixoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.model.Regiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegiaoRepository extends JpaRepository<Regiao, Long> {
    @Query("SELECT SUM(lc.quantidade) AS totalLixo, rg.nome AS nomeRegiao, tc.descricao AS nomeColeta " +
            "FROM LixoColetado lc " +
            "JOIN ColetaRua cr ON lc.coletaRuaId = cr.id " +
            "JOIN Rua r ON cr.ruaId = r.id " +
            "JOIN Bairro b ON r.bairroId = b.id " +
            "JOIN Regiao rg ON b.regiaoId = rg.id " +
            "JOIN TipoColeta tc ON cr.tipoColetaId = tc.id " +
            "WHERE (:idRegiao IS NULL OR rg.id = :idRegiao) " +
            "AND (:idTipoColeta IS NULL OR tc.id = :idTipoColeta) " +
            "GROUP BY rg.id, rg.nome, tc.descricao " +
            "ORDER BY SUM(lc.quantidade) DESC " +
            "LIMIT 1")
    List<Object[]> regiaoMaisLixo(@Param("idRegiao") Long idRegiao, @Param("idTipoColeta") Long idTipoColeta);
}
