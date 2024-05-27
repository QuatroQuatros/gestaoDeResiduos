package br.com.quatroquatros.gestaoDeResiduos.model;

import br.com.quatroquatros.gestaoDeResiduos.model.valueObject.ColetaDiaStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name="COLETAS_RUAS")
@Getter
@Setter
public class ColetaRua {


    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "COLETAS_RUAS_SEQ"
    )
    @SequenceGenerator(
            name="COLETAS_RUAS_SEQ",
            sequenceName = "COLETAS_RUAS_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "id_usuario_solicitante")
    private Long usuarioSolicitanteId;

    @Column(name = "id_rua")
    private Long ruaId;

    @Column(name = "ID_TIPO_COLETA")
    private Long tipoColetaId;

    @Column(name = "DATA_AGENDAMENTO")
    private LocalDate dataAgendamento;

    @Column(name = "DATA_COLETA")
    private LocalDate dataColeta;

    private ColetaDiaStatus status;

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
