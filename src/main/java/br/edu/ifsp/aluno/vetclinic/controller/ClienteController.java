package br.edu.ifsp.aluno.vetclinic.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifsp.aluno.vetclinic.domain.Cliente;
import br.edu.ifsp.aluno.vetclinic.service.ClienteService;

@RequestMapping("/authorized/clientes")
@Controller()
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String indice(Model model) {
        model.addAttribute("clientes", clienteService.listar());
        return "clientes/index";
    }
    
    @GetMapping("/criar")
    public String criar(Model model) {
        model.addAttribute("action", "/authorized/clientes");
        model.addAttribute("method", "post");
        return "clientes/form";
    }
    
    @PostMapping()
    public String salvar(Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/authorized/clientes";
    }
    
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("cliente", clienteService.encontrarPorId(id));
        model.addAttribute("action", "/authorized/clientes/" + id);
        model.addAttribute("method", "PUT");
        return "clientes/form";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String atualizar(Cliente cliente) {
        clienteService.salvar(cliente);
        return "redirect:/authorized/clientes";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deletar(@PathVariable(value = "id") Long id) {
        clienteService.deletar(id);
        return "redirect:/authorized/clientes";
    }
}
