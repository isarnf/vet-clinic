package br.edu.ifsp.aluno.vetclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.aluno.vetclinic.dao.AnimalDao;
import br.edu.ifsp.aluno.vetclinic.domain.Animal;

@Service
public class AnimalServiceImpl implements AnimalService{
    @Autowired
    private AnimalDao animalDao;

    @Override
    public void deletar(Long id) {
        animalDao.deleteById(id);
    }

    @Override
    public Animal encontrarPorId(Long id) {
        return animalDao.findById(id).orElseThrow();
    }

    @Override
    public List<Animal> listar() {
        return animalDao.findAll();
    }

    @Override
    public Animal salvar(Animal animal) {
        return animalDao.save(animal);
    }
    
}
