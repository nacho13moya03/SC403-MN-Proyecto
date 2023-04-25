package com.web.controller;

import com.web.domain.Articulo;
import com.web.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/catalogue")
public class ProductoController {

    @Autowired
    ArticuloService articuloService;
    @GetMapping("/producto/{idArticulo}")
    public String inicio(Model model, Articulo articulo) {
        articulo = articuloService.getArticuloCatalogo(articulo);
        model.addAttribute("articulo", articulo);
        return "producto";
    }

}
