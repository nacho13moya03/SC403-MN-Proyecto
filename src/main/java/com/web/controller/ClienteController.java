package com.web.controller;

import com.web.domain.Cliente;
import com.web.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;


@Controller
@RequestMapping("/users")
public class ClienteController {

    Long id;

    @Autowired
    ClienteService clienteService;

    @PostMapping("/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/users/registroOK";
    }

    @PostMapping("/guardarActualizado")
    public String guardarActualizado(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/users/profile";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.deleteCliente(cliente);
        return "redirect:/inicio";
    }

    @GetMapping("/modificar/{idCliente}")
    public String modificaCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/modificar_perfil";
    }

  @PostMapping("/acceder")
  public String processLoginForm(@RequestParam("correo") String correo,
                                 @RequestParam("password") String password,
                                 Model model) {
      Cliente user = clienteService.getUserByEmail(correo);
       if (user != null && user.getPassword().equals(password)) {
            id = user.getIdCliente();
           model.addAttribute("user", user);
           return "inicio";

      }else {
          return "users/inicio_sesion";
      }
  }

    @GetMapping("/profile")
    public String profile(Model model) {
        var clientes = clienteService.getClientes();

        for (var c:clientes) {
            if(c.getIdCliente().equals(id)){
                model.addAttribute("c", c);
                return "users/perfil";
            }
        }

        return "users/inicio_sesion";
    }

}
