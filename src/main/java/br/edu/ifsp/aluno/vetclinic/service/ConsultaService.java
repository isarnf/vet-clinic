package br.edu.ifsp.aluno.vetclinic.service;

import java.util.List;

import br.edu.ifsp.aluno.vetclinic.domain.Consulta;

public interface ConsultaService extends CRUDService<String, Consulta> {
    List<Consulta> encontrarConsultarPorVeterinario(Long id);
}
