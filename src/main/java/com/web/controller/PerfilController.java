package com.web.controller;

import com.web.dao.ClienteDao;
import com.web.domain.Cliente;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class PerfilController {
    @GetMapping("/perfil")
    public String inicio(Model model) {
        return "perfil";
    }
}
