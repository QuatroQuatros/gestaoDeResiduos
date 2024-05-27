package br.com.quatroquatros.gestaoDeResiduos.repository;

import br.com.quatroquatros.gestaoDeResiduos.model.TipoColeta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoColetaRepository extends JpaRepository<TipoColeta, Long> {
}
