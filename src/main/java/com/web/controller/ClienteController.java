package com.web.controller;

import com.web.domain.Cliente;
import com.web.service.ClienteService;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/users")
public class ClienteController {

    private final Logger log = LoggerFactory.getLogger(RegistroController.class);

    @Autowired
    ClienteService clienteService;

    @PostMapping("/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/users/registroOK";
    }

    @PostMapping("/acceder")
    public String acceder(Cliente cliente, HttpSession session){
        log.info("Informacion e login: {}",cliente);

        Optional<Cliente> user = clienteService.findByCorreo(cliente.getCorreo());
        log.info("Usuario desde db: {}",user.get());

        if(user.isPresent()){
            session.setAttribute("idCliente",user.get().getIdCliente());
            /*if(user.get().getTipo().equals("ADMIN")){
                return "redirect:/administrador";
            }else{
                return "redirect:/home";
            }*/
        }
        else{
            log.info("usuarioinexistente");
        }
        return "redirect:/index";
    }
}
