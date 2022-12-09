package br.edu.ifsp.aluno.vetclinic.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.aluno.vetclinic.domain.Veterinario;

public interface VeterinarioDao extends JpaRepository<Veterinario, Long> {
    Veterinario findByEmail(String email);
}
