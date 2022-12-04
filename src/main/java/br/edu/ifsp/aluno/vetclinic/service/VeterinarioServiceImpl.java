package br.edu.ifsp.aluno.vetclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.aluno.vetclinic.dao.VeterinarioDao;
import br.edu.ifsp.aluno.vetclinic.domain.Veterinario;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {
    @Autowired
    private VeterinarioDao veterinarioDao;

    @Override
    public void deletar(Long id) {
        veterinarioDao.deleteById(id);
    }

    @Override
    public Veterinario encontrarPorId(Long id) {
        return veterinarioDao.findById(id).orElseThrow();
    }

    @Override
    public List<Veterinario> listar() {
        return veterinarioDao.findAll();
    }

    @Override
    public Veterinario salvar(Veterinario veterinario) {
        return veterinarioDao.save(veterinario);
    }
    
}
