package com.web.controller;

import com.web.domain.Articulo;
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
public class CatalogueController {
    @Autowired
    ArticuloService articuloService;
    @GetMapping("/bebes")
    public String bebes(Model model) {
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

    @GetMapping("/catalogos")
    public String catalogos(Model model) {
        var articulos = articuloService.getArticulosCatalogos();
        model.addAttribute("articulos", articulos);
        model.addAttribute("totalArticulos",articulos.size());
        return "catalogos";
    }

    @GetMapping("/hombres")
    public String hombre(Model model) {
        var articulos = articuloService.getArticulosCatalogos();
        List art = new ArrayList(); ;

        for (var a:articulos) {
            if (a.getCategoria().getIdCategoria()==4L) {
                art.add(a);
            }
        }
        model.addAttribute("art", art);
        return "hombres";
    }

    @GetMapping("/mujeres")
    public String mujeres(Model model) {
        var articulos = articuloService.getArticulosCatalogos();
        List art = new ArrayList(); ;
        for (var a:articulos) {
            if (a.getCategoria().getIdCategoria()==3L) {
                art.add(a);
            }
        }
        model.addAttribute("art", art);
        return "mujeres";
    }

    @GetMapping("/niños")
    public String niños(Model model) {
        var articulos = articuloService.getArticulosCatalogos();
        List art = new ArrayList(); ;

        for (var a:articulos) {
            if (a.getCategoria().getIdCategoria()==2L) {
                art.add(a);
            }
        }
        model.addAttribute("art", art);
        return "niños";
    }

    @GetMapping("/producto/{idArticulo}")
    public String producto(Model model, Articulo articulo) {
        articulo = articuloService.getArticuloCatalogo(articulo);
        model.addAttribute("articulo", articulo);
        return "producto";
    }
}