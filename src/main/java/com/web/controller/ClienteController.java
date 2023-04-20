package com.web.controller;

import com.web.domain.Cliente;
import com.web.service.ClienteService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.deleteCliente(cliente);
        return "redirect:/index";
    }

    @GetMapping("/modificar/{idCliente}")
    public String modificaCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/users/perfil";
    }

  /*  @PostMapping("/acceder")
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
            }
        }
        else{
            log.info("usuarioinexistente");
        }
        return "redirect:/index";
    }*/
  @PostMapping("/acceder")
  public String processLoginForm(@RequestParam("correo") String correo,
                                 @RequestParam("password") String password,
                                 Model model) {
      Cliente user = clienteService.getUserByEmail(correo);
       if (user != null && user.getPassword().equals(password)) {
          // Si las credenciales son válidas, guardar el ID del usuario en la sesión
          //session.setAttribute("userIdCliente", user.getIdCliente());
          //return "users/perfil";
          //return "redirect:/users/profile";
           model.addAttribute("user", user);
           return "users/perfil";

      }else {
          //redirectAttributes.addAttribute("error", "true");
          //model.addAttribute("error", "Nombre de usuario o contraseña incorrectos");
          return "users/inicio_sesion";
         // return "redirect:/acceder";
      }
  }

   // private ClienteDao clienteDao;
    /*@GetMapping("/profile")
    public String profile(Model model) {
        Cliente user = clienteService.getUserById(id);
        if(user==null){
            return "redirect:/acceder";
        }
        model.addAttribute("user", user);
        return "perfil";
       /* Long userId = (Long) session.getAttribute("userId");
        Cliente user = clienteDao.findById(userId).orElse(null);
        if (user == null) {
            //return new ModelAndView("redirect:/users/inicio_sesion");
        }
        ModelAndView mav = new ModelAndView("perfil");
        mav.addObject("user", user);
        model.addAttribute("user", user);
        System.out.println(user.getNombre());
        return "perfil";
        // return mav;
    }
*/

}
