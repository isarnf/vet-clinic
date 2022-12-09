package br.edu.ifsp.aluno.vetclinic.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.aluno.vetclinic.domain.Consulta;

public interface ConsultaDao extends JpaRepository<Consulta, String> {
    List<Consulta> findByVeterinarioId(Long id);
}
