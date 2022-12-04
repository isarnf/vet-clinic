package br.edu.ifsp.aluno.vetclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifsp.aluno.vetclinic.domain.Veterinario;
import br.edu.ifsp.aluno.vetclinic.service.VeterinarioService;

@RequestMapping("/veterinarios")
@Controller
public class VeterinarioController {
    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping
    public String indice(Model model) {
        model.addAttribute("veterinarios", veterinarioService.listar());
        return "veterinarios/index";
    }
    
    @GetMapping("/criar")
    public String criar(Model model) {
        model.addAttribute("action", "/veterinarios");
        model.addAttribute("method", "post");
        return "veterinarios/form";
    }
    
    @PostMapping()
    public String salvar(Veterinario veterinario) {
        veterinarioService.salvar(veterinario);
        return "redirect:/veterinarios";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("veterinario", veterinarioService.encontrarPorId(id));
        model.addAttribute("action", "/veterinarios/" + id);
        model.addAttribute("method", "PUT");
        return "veterinarios/form";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String atualizar(Veterinario veterinario) {
        veterinarioService.salvar(veterinario);
        return "redirect:/veterinarios";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletar(@PathVariable(value = "id") Long id) {
        veterinarioService.deletar(id);
        return "redirect:/veterinarios";
    }
}
