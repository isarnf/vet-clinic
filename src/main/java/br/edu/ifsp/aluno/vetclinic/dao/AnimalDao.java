package br.edu.ifsp.aluno.vetclinic.dao;

import java.util.List;

import br.edu.ifsp.aluno.vetclinic.domain.Animal;

public interface AnimalDao {
    void save(Animal animal);
    void update(Animal animal);
    void delete(Long id);

    Animal findById(Long id);

    List<Animal> findByNome(String nome);

    List<Animal> findByRaca(String raca);

    List<Animal> findAll();
    
}
