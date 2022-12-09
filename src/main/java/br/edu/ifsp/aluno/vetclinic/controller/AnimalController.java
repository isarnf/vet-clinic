package br.edu.ifsp.aluno.vetclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifsp.aluno.vetclinic.domain.Animal;
import br.edu.ifsp.aluno.vetclinic.service.AnimalService;

@RequestMapping("/animais")
@Controller()
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @GetMapping
    public String indice(Model model) {
        model.addAttribute("animais", animalService.listar());
        return "animais/index";
    }
    
    @GetMapping("/criar")
    public String criar(Model model) {
        model.addAttribute("action", "/animais");
        model.addAttribute("method", "post");
        return "animais/form";
    }
    
    @PostMapping()
    public String salvar(Animal animal) {
        animalService.salvar(animal);
        return "redirect:/animais";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("animal", animalService.encontrarPorId(id));
        model.addAttribute("action", "/animais/" + id);
        model.addAttribute("method", "PUT");
        return "animais/form";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String atualizar(Animal animal) {
        animalService.salvar(animal);
        return "redirect:/animais";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletar(@PathVariable(value = "id") Long id) {
        animalService.deletar(id);
        return "redirect:/animais";
    }
}
