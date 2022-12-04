package br.edu.ifsp.aluno.vetclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifsp.aluno.vetclinic.domain.Consulta;
import br.edu.ifsp.aluno.vetclinic.service.AnimalService;
import br.edu.ifsp.aluno.vetclinic.service.ConsultaService;

@RequestMapping("/consultas")
@Controller
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public String indice(Model model) {
        model.addAttribute("consultas", consultaService.listar());
        return "consultas/index";
    }
    
    @GetMapping("/criar")
    public String criar(Model model) {
        model.addAttribute("action", "/consultas");
        model.addAttribute("method", "post");
        model.addAttribute("animais", animalService.listar());
        return "consultas/form";
    }
    
    @PostMapping()
    public String salvar(Consulta consulta) {
        consultaService.salvar(consulta);
        return "redirect:/consultas";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("veterinario", consultaService.encontrarPorId(id));
        model.addAttribute("action", "/consultas/" + id);
        model.addAttribute("method", "PUT");
        return "consultas/form";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String atualizar(Consulta consulta) {
        consultaService.salvar(consulta);
        return "redirect:/consultas";
    }
}
