package br.edu.ifsp.aluno.vetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("headerHidden", Boolean.FALSE);
        return "/home";
    }
}

