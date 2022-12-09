package br.edu.ifsp.aluno.vetclinic.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "consultas")
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    @DateTimeFormat(iso = ISO.DATE_TIME)
    @Column(name="data_horario")
    private LocalDateTime dataHorario;

    public enum ConsultaStatus {
        ABERTO,
        CONCLUIDO,
        DESMARCADO
    };

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    public ConsultaStatus status;

    private Long formVeterinarioId;
    private Long formAnimalId;
}
