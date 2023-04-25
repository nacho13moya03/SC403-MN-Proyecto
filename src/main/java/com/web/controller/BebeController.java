package com.web.controller;

import com.web.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/catalogue")
public class BebeController {
    @Autowired
    ArticuloService articuloService;
    @GetMapping("/bebes")
    public String inicio(Model model) {
        var articulos = articuloService.getArticulosCatalogos();
        List art = new ArrayList(); ;

        for (var a:articulos) {
            if (a.getCategoria().getIdCategoria()==1L) {
                art.add(a);
            }
        }
        model.addAttribute("art", art);
        return "bebes";
    }
}
