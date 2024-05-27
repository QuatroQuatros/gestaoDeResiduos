package br.com.quatroquatros.gestaoDeResiduos.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="TIPOS_COLETAS")
@Getter
@Setter
public class TipoColeta {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TIPOS_COLETAS_SEQ"
    )
    @SequenceGenerator(
            name="TIPOS_COLETAS_SEQ",
            sequenceName = "TIPOS_COLETAS_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "DESCRICAO")
    private String descricao;

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
