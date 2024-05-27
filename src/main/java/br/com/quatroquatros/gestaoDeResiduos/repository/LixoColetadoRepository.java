package br.com.quatroquatros.gestaoDeResiduos.repository;

import br.com.quatroquatros.gestaoDeResiduos.model.LixoColetado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LixoColetadoRepository extends JpaRepository<LixoColetado, Long> {
}
