package br.edu.ifsp.aluno.vetclinic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.aluno.vetclinic.domain.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long> {}
