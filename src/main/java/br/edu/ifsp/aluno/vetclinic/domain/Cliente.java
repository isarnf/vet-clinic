package br.edu.ifsp.aluno.vetclinic.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Table(name = "clientes")
@Entity
public class Cliente extends AbstractEntity<Long>{
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(name="nome",nullable = false)
    private String nome;

    @Column(name="telefone",nullable = false)
    private String telefone;

    @Column(name="email",nullable = false)
    private String email;


    
}
