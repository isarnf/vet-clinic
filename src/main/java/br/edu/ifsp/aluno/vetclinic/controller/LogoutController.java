package br.edu.ifsp.aluno.vetclinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifsp.aluno.vetclinic.dao.VeterinarioDao;
import br.edu.ifsp.aluno.vetclinic.domain.Veterinario;
import jakarta.servlet.http.HttpSession;
import lombok.Data;


@RequestMapping("/logoff")
@Controller
public class LogoutController {
    @PostMapping
    public String logout(HttpSession httpSession){
        httpSession.removeAttribute("veterinario_id");
        return "redirect:/";
    }
}
