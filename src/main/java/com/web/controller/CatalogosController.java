package com.web.controller;

import com.web.service.ArticuloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping("/catalogue")
public class CatalogosController {

    @Autowired
    ArticuloService articuloService;

    @GetMapping("/catalogos")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulosCatalogos();
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalArticulos",articulos.size());
        return "catalogos";
    }

}

