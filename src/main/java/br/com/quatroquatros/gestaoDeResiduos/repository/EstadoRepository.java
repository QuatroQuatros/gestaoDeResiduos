package br.com.quatroquatros.gestaoDeResiduos.repository;

import br.com.quatroquatros.gestaoDeResiduos.dto.estado.EstadoMaisLixoExibicaoDto;
import br.com.quatroquatros.gestaoDeResiduos.model.Estado;
import br.com.quatroquatros.gestaoDeResiduos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    @Query("SELECT CASE WHEN COUNT(e) > 0 THEN true ELSE false END FROM Estado e WHERE e.uf = :uf")
    boolean existsByUf(String uf);

    Optional<Estado> findByUf(String uf);

    @Query("SELECT SUM(lc.quantidade) AS totalLixo, e.nome AS nomeEstado, tc.descricao AS nomeColeta " +
            "FROM LixoColetado lc " +
            "JOIN ColetaRua cr ON lc.coletaRuaId = cr.id " +
            "JOIN Rua r ON cr.ruaId = r.id " +
            "JOIN Bairro b ON r.bairroId = b.id " +
            "JOIN Regiao rg ON b.regiaoId = rg.id " +
            "JOIN Estado e ON rg.estado.id = e.id " +
            "JOIN TipoColeta tc ON cr.tipoColetaId = tc.id " +
            "WHERE (:idEstado IS NULL OR e.id = :idEstado) " +
            "AND (:idTipoColeta IS NULL OR tc.id = :idTipoColeta) " +
            "GROUP BY e.id, e.nome, tc.descricao " +
            "ORDER BY SUM(lc.quantidade) DESC " +
            "LIMIT 1")
    List<Object[]> estadoMaisLixo(@Param("idEstado") Long idEstado, @Param("idTipoColeta") Long idTipoColeta);

}
