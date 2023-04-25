package com.web.controller;

import com.web.service.ArticuloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

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

    @PostMapping("/buscar")
    public String buscar(@RequestParam("q") String tipo,Model model) {
        var articulos = articuloService.getArticulosCatalogos();
        List buscar = new ArrayList();
        for (var a:articulos) {
            if (a.getTipo().equals(tipo)) {
                buscar.add(a);
            }
        }
        model.addAttribute("buscar", buscar);
        return "buscar";
    }

}

