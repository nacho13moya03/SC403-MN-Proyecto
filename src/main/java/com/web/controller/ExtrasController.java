package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/extras")
public class ExtrasController {
    @GetMapping("/carrito")
    public String carrit(Model model) {
        return "carrito";
    }

    @GetMapping("/compra_exitosa")
    public String exitosa(Model model) {
        return "compra_exitosa";
    }

    @GetMapping("/info")
    public String info(Model model) {
        return "/extras/info";
    }

    @GetMapping("/metodo_pago")
    public String inicio(Model model) {
        return "metodo_pago";
    }
}