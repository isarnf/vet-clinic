package br.edu.ifsp.aluno.vetclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.aluno.vetclinic.dao.ConsultaDao;
import br.edu.ifsp.aluno.vetclinic.domain.Consulta;

@Service
public class ConsultaServiceImpl implements ConsultaService {
    @Autowired
    private ConsultaDao consultaDao;

    @Override
    public List<Consulta> encontrarConsultarPorVeterinario(Long id) {
        return consultaDao.findByVeterinarioId(id);
    }

    @Override
    public void deletar(String id) {
        consultaDao.deleteById(id);
    }

    @Override
    public Consulta encontrarPorId(String id) {
        return consultaDao.findById(id).orElseThrow();
    }

    @Override
    public List<Consulta> listar() {
        return consultaDao.findAll();
    }

    @Override
    public Consulta salvar(Consulta consulta) {
        return consultaDao.save(consulta);
    }
    
}
