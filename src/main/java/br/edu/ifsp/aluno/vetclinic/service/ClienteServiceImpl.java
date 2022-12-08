package br.edu.ifsp.aluno.vetclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.aluno.vetclinic.dao.ClienteDao;
import br.edu.ifsp.aluno.vetclinic.domain.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    private ClienteDao clienteDao;

    @Override
    public void deletar(Long id) {
        clienteDao.deleteById(id);
    }

    @Override
    public Cliente encontrarPorId(Long id) {
        return clienteDao.findById(id).orElseThrow();
    }

    @Override
    public List<Cliente> listar() {
        return clienteDao.findAll();
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        return clienteDao.save(cliente);
    }
}
