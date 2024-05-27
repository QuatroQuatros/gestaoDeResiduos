package br.com.quatroquatros.gestaoDeResiduos.model;


import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="estados")
@Getter
@Setter
public class Estado {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ESTADOS_SEQ"
    )
    @SequenceGenerator(
            name="ESTADOS_SEQ",
            sequenceName = "ESTADOS_SEQ",
            allocationSize = 1
    )
    private Long id;
    private String nome;

    private String uf;
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estado estado = (Estado) o;
        return Objects.equals(id, estado.id) && Objects.equals(nome, estado.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
