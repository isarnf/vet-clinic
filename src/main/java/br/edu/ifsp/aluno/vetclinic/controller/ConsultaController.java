package br.edu.ifsp.aluno.vetclinic.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.ifsp.aluno.vetclinic.domain.Animal;
import br.edu.ifsp.aluno.vetclinic.domain.Consulta;
import br.edu.ifsp.aluno.vetclinic.domain.Veterinario;
import br.edu.ifsp.aluno.vetclinic.service.AnimalService;
import br.edu.ifsp.aluno.vetclinic.service.ConsultaService;
import br.edu.ifsp.aluno.vetclinic.service.VeterinarioService;
import jakarta.servlet.http.HttpSession;

@RequestMapping("authorized/consultas")
@Controller
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;
    @Autowired
    private AnimalService animalService;
    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping
    public String indice(Model model, HttpSession session) {    
        Long veterinarioId = (Long)session.getAttribute("veterinario_id");

        model.addAttribute("consultas", consultaService.encontrarConsultarPorVeterinario(veterinarioId));
        return "consultas/index";
    }
    
    @GetMapping("/criar")
    public String criar(Model model) {
        model.addAttribute("action", "/authorized/consultas");
        model.addAttribute("method", "post");
        model.addAttribute("animais", animalService.listar());
        model.addAttribute("status", Consulta.ConsultaStatus.values());
        model.addAttribute("statusValue", Consulta.ConsultaStatus.ABERTO);
        model.addAttribute("statusHidden", true);
        model.addAttribute("mainDisabled", false);
        model.addAttribute("veterinarios", veterinarioService.listar());
        return "consultas/form";
    }
    
    @PostMapping()
    public String salvar(Consulta consulta) {
        Veterinario veterinario = veterinarioService.encontrarPorId(consulta.getFormVeterinarioId());
        Animal animal = animalService.encontrarPorId(consulta.getFormAnimalId());

        consulta.setAnimal(animal);
        consulta.setVeterinario(veterinario);

        consultaService.salvar(consulta);
        return "redirect:/authorized/consultas";
    }
    
    @GetMapping("/{id}/ver")
    public String editar(@PathVariable(value = "id") String id, HttpSession httpSession, Model model) {
        model.addAttribute("consulta", consultaService.encontrarPorId(id));
        model.addAttribute("action", "/authorized/consultas/" + id);
        model.addAttribute("method", "PUT");
        model.addAttribute("status", Consulta.ConsultaStatus.values());
        model.addAttribute("statusHidden", null);
        model.addAttribute("mainDisabled", true);

        model.addAttribute("animais", animalService.listar());

        Long veterinarioId = (Long)httpSession.getAttribute("veterinario_id");
        Veterinario veterinario = veterinarioService.encontrarPorId(veterinarioId);

        model.addAttribute("veterinarios", List.of(veterinario));
        return "consultas/form";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String atualizar(Consulta consulta) {
        Consulta foundConsulta = consultaService.encontrarPorId(consulta.getId());
        foundConsulta.setStatus(consulta.getStatus());

        consultaService.salvar(foundConsulta);
        return "redirect:/authorized/consultas";
    }
}
