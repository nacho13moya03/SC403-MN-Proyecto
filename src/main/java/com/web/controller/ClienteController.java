package com.web.controller;

import com.web.domain.Cliente;
import com.web.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/guardar")
    public String guardaArticulo(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/users/registroOK";
    }
}
