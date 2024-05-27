package br.com.quatroquatros.gestaoDeResiduos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="regioes")
@Getter
@Setter
public class Regiao {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "REGIOES_SEQ"
    )
    @SequenceGenerator(
            name="REGIOES_SEQ",
            sequenceName = "REGIOES_SEQ",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado")
    private Estado estado;

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
