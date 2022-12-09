package br.edu.ifsp.aluno.vetclinic.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "animais")
public class Animal extends AbstractEntity<Long>{

    @Column(name="id",nullable = false, unique = true)
    private Long id;

    @Column(name="nome",nullable = false)
    private String nome;

    @Column(name="especie",nullable = false)
    private String especie;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name="data_nascimento",nullable = true)
    private LocalDate dataNascimento;

    @Column(name="sexo",nullable = false)
    private String sexo;

    @Column(name="peso",nullable = false)
    private Double peso;

    @Column(name="raca",nullable = true)
    private String raca;
}
