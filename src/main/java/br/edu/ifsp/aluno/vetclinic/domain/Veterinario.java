package br.edu.ifsp.aluno.vetclinic.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "veterinarios")
@Entity
public class Veterinario extends AbstractEntity<Long> {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String crmv;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;
}
