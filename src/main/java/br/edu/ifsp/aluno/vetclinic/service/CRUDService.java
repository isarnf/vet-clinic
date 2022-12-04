package br.edu.ifsp.aluno.vetclinic.service;

import java.util.List;

public interface CRUDService<K, T> {
    List<T> listar();
    T encontrarPorId(K k);
    T salvar(T t);
    void deletar(K k);
}
