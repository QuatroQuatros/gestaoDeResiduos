package br.com.quatroquatros.gestaoDeResiduos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name="ruas")
@Getter
@Setter
public class Rua {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "RUAS_SEQ"
    )
    @SequenceGenerator(
            name="RUAS_SEQ",
            sequenceName = "RUAS_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "id_bairro")
    private Long bairroId;

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
