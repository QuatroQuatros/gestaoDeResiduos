package br.com.quatroquatros.gestaoDeResiduos.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="LIXO_COLETADO")
@Getter
@Setter
public class LixoColetado {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "LIXO_COLETADO_SEQ"
    )
    @SequenceGenerator(
            name="LIXO_COLETADO_SEQ",
            sequenceName = "LIXO_COLETADO_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "ID_COLETA_RUA")
    private Long coletaRuaId;

    private Double  quantidade;

    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
