package br.edu.ifsp.aluno.vetclinic.dao;

import java.util.List;

import br.edu.ifsp.aluno.vetclinic.domain.Cliente;

public interface ClienteDao {
    void save(Cliente cliente);
    void update(Cliente cliente);
    void delete(Long id);

    Cliente findById(Long id);

    Cliente findByEmail(String email);

    Cliente findByCpf(String cpf);

    List<Cliente> findByNome(String nome);

    List<Cliente> findAll();

    
    
}
