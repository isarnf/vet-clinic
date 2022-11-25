package br.edu.ifsp.aluno.vetclinic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
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
