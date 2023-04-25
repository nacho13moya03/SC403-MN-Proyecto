package com.web.controller;

import com.web.domain.ConfigBD;
import com.web.service.ConfigBDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/base_datos")
public class Base_DatosController {
    @GetMapping("/modificar")
    public String modificar(Model model) {
        return "modificar";
    }

    @Autowired
    ConfigBDService catalogueService;

    @GetMapping("/configuracion")
    public String config(Model model) {
        var articulos = catalogueService.getArticulos();
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalArticulos", articulos.size());
        return "configuracion";
    }

    @GetMapping("/eliminar/{idArticulo}")
    public String eliminaArticulo(ConfigBD articulo) {
        catalogueService.deleteArticulo(articulo);
        return "redirect:/base_datos/configuracion";
    }

    @GetMapping("/nuevo")
    public String nuevoArticulo(ConfigBD articulo) {
        return "/catalogue/modify";
    }

    @PostMapping("/guardar")
    public String guardaArticulo(ConfigBD articulo) {
        catalogueService.saveArticulo(articulo);
        return "redirect:/base_datos/configuracion";
    }

    @GetMapping("/modificar/{idArticulo}")
    public String modificaArticulo(ConfigBD articulo, Model model) {
        articulo = catalogueService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/base_datos/modificar";

    }
}