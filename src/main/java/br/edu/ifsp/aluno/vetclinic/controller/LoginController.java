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


@RequestMapping("/login")
@Controller
public class LoginController {
    @Data
    public class LoginDTO {
        private String email;
        private String senha;
    }

    @Autowired
    private VeterinarioDao veterinarioDao;

    @PostMapping()
    public String login(HttpSession httpSession, LoginDTO loginDTO){
        Veterinario veterinario = veterinarioDao.findByEmail(loginDTO.getEmail());
        if (veterinario != null && loginDTO.getSenha().equals(veterinario.getSenha())){
            httpSession.setAttribute("veterinario_id", veterinario.getId());
            return "redirect:/authorized/consultas";
        }
        return "redirect:/";
    }
}
