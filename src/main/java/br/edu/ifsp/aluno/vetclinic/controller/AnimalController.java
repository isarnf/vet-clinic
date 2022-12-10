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
import br.edu.ifsp.aluno.vetclinic.domain.Cliente;
import br.edu.ifsp.aluno.vetclinic.service.AnimalService;
import br.edu.ifsp.aluno.vetclinic.service.ClienteService;

@RequestMapping("/authorized/animais")
@Controller()
public class AnimalController {
    @Autowired
    private AnimalService animalService;
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String indice(Model model) {
        model.addAttribute("animais", animalService.listar());
        return "animais/index";
    }
    
    @GetMapping("/criar")
    public String criar(Model model) {
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("action", "/authorized/animais");
        model.addAttribute("method", "post");
        return "animais/form";
    }
    
    @PostMapping()
    public String salvar(Animal animal) {
        Cliente cliente = clienteService.encontrarPorId(animal.getFormClienteId());
        animal.setCliente(cliente);
        animalService.salvar(animal);
        return "redirect:/authorized/animais";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("animal", animalService.encontrarPorId(id));
        model.addAttribute("clientes", clienteService.listar());
        model.addAttribute("action", "/authorized/animais/" + id);
        model.addAttribute("method", "PUT");
        return "animais/form";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String atualizar(Animal animal) {
        Cliente cliente = clienteService.encontrarPorId(animal.getFormClienteId());
        animal.setCliente(cliente);
        animalService.salvar(animal);
        return "redirect:/authorized/animais";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletar(@PathVariable(value = "id") Long id) {
        animalService.deletar(id);
        return "redirect:/authorized/animais";
    }
}
