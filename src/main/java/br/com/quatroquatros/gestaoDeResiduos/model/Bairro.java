package br.com.quatroquatros.gestaoDeResiduos.model;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="bairros")
@Getter
@Setter
public class Bairro {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "BAIRROS_SEQ"
    )
    @SequenceGenerator(
            name="BAIRROS_SEQ",
            sequenceName = "BAIRROS_SEQ",
            allocationSize = 1
    )
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ID_REGIAO")
//    private Regiao regiao;

    @Column(name = "id_regiao")
    private Long regiaoId;

    private String nome;

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
