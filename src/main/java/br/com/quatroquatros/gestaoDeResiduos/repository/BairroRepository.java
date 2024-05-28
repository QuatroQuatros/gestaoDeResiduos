package br.com.quatroquatros.gestaoDeResiduos.repository;

import br.com.quatroquatros.gestaoDeResiduos.model.Bairro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BairroRepository extends JpaRepository<Bairro, Long> {
    @Query("SELECT SUM(lc.quantidade) AS totalLixo, b.nome AS nomeBairro, tc.descricao AS nomeColeta " +
            "FROM LixoColetado lc " +
            "JOIN ColetaRua cr ON lc.coletaRuaId = cr.id " +
            "JOIN Rua r ON cr.ruaId = r.id " +
            "JOIN Bairro b ON r.bairroId = b.id " +
            "JOIN TipoColeta tc ON cr.tipoColetaId = tc.id " +
            "WHERE (:idBairro IS NULL OR b.id = :idBairro) " +
            "AND (:idTipoColeta IS NULL OR tc.id = :idTipoColeta) " +
            "GROUP BY b.id, b.nome, tc.descricao " +
            "ORDER BY SUM(lc.quantidade) DESC " +
            "LIMIT 1")
    List<Object[]> bairroMaisLixo(@Param("idBairro") Long idBairro, @Param("idTipoColeta") Long idTipoColeta);
}
