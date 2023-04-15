package com.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import com.web.domain.Cliente;
import com.web.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
public class ClienteController {

    @Autowired
    ClienteService clienteService;
    @PostMapping("cliente/guardar")
    public String guardaCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/registroOK";
    }
}
