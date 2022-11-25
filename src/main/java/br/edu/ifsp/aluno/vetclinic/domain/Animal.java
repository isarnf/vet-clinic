package br.edu.ifsp.aluno.vetclinic.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "animais")
public class Animal extends AbstractEntity<Long>{

    @Column(name="nome",nullable = false)
    private String nome;

    @Column(name="especie",nullable = false)
    private String especie;

    @DateTimeFormat(iso = ISO.DATE)
    @Column(name="data_nascimento",nullable = true)
    private LocalDate data_nascimento;

    @Column(name="sexo",nullable = false)
    private String sexo;

    @Column(name="peso",nullable = false)
    private Double peso;

    @Column(name="raca",nullable = true)
    private String raca;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }
    
  
}
