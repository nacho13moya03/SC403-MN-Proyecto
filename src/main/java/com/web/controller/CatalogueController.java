package com.web.controller;

import com.web.domain.Catalogue;
import com.web.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/catalogue")
public class CatalogueController {
    @Autowired
    CatalogueService catalogueService;
    @GetMapping("/catalogs")
    public String inicio(Model model) {
        //   var articulos = articuloService.getArticulos(false);
        var articulos = catalogueService.getArticulos(false);
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalArticulos",articulos.size());
        return "/catalogue/catalogs";
    }

    @GetMapping("/eliminar/{idArticulo}")
    public String eliminaArticulo(Catalogue articulo) {
        catalogueService.deleteArticulo(articulo);
        return "redirect:/articulo/listado";
    }

    @GetMapping("/nuevo")
    public String nuevoArticulo(Catalogue articulo) {
        return "/catalogue/modify";
    }
    @PostMapping("/guardar")
    public String guardaArticulo(Catalogue articulo) {
        catalogueService.saveArticulo(articulo);
        return "redirect:/catalogue/catalogs";
    }

    @GetMapping("/modificar/{idArticulo}")
    public String modificaArticulo(Catalogue articulo, Model model) {
        articulo = catalogueService.getArticulo(articulo);
        model.addAttribute("articulo", articulo);
        return "/articulo/modifica";
    }
}

