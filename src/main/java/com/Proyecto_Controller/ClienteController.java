/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Controller;

import com.Proyecto.Domain.Cliente;
import com.Proyecto.Service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";    
    }
    
    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modificar";
    }
    
    @PostMapping("/cliente/guardar")
    public String guardaCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente/listado";
    }
    
    
    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminaCliente(Cliente cliente) {
        clienteService.deleteCliente(cliente);
        return "redirect:/cliente/listado";
    }
    
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificaCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente",cliente);
        return "redirect:/cliente/listado";
    }
    
}
