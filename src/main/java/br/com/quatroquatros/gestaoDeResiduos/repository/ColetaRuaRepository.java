package br.com.quatroquatros.gestaoDeResiduos.repository;

import br.com.quatroquatros.gestaoDeResiduos.model.ColetaRua;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ColetaRuaRepository extends JpaRepository<ColetaRua, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE ColetaRua c SET c.status = 2 WHERE c.id = :idColeta")
    int marcarColetaConcluida(@Param("idColeta") Long idColeta);

    @Query("SELECT cr FROM ColetaRua cr WHERE cr.dataAgendamento BETWEEN :startDate AND :endDate")
    List<ColetaRua> findByDataAgendamentoBetween(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
