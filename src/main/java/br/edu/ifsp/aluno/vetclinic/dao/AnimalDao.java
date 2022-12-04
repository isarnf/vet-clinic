package br.edu.ifsp.aluno.vetclinic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsp.aluno.vetclinic.domain.Animal;

@Repository
public interface AnimalDao extends JpaRepository<Animal, Long>{}
