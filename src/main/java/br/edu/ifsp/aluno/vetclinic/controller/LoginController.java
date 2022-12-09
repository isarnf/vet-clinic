package br.edu.ifsp.aluno.vetclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.ifsp.aluno.vetclinic.dao.VeterinarioDao;


@Controller
public class LoginController {
    private VeterinarioDao veterinarioDao;

    @GetMapping("/")
    public String login(String email, String senha){
        if (veterinarioDao.findByEmail(email) != null){
            return "/consultas/index";
        }
        return null;
    }
}
