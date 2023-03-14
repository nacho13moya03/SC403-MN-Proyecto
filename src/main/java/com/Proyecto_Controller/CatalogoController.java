/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Controller;

import com.Proyecto.Domain.Catalogo;
import com.Proyecto.Service.CatalogoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class CatalogoController {
    
    @Autowired
    CatalogoService catalogoService;
    
    @GetMapping("/catalogo/listado")
    public String inicio(Model model) {
        var catalogos = catalogoService.getCatalogo(false);
        model.addAttribute("catalogos", catalogos);
        return "/catalogo/listado";    
    }
    
    @GetMapping("/catalogo/nuevo")
    public String nuevoCatalogo(Catalogo catalogo) {
        return "/catalogo/modificar";
    }
    
    @PostMapping("/catalogo/guardar")
    public String guardaCatalogo(Catalogo catalogo) {
        catalogoService.save(catalogo);
        return "redirect:/catalogo/listado";
    }
    
    
    @GetMapping("/catalogo/eliminar/{idCategoria}")
    public String eliminarCatalogo(Catalogo catalogo) {
        catalogoService.delete(catalogo);
        return "redirect:/catalogo/listado";
    }
    
    @GetMapping("/catalogo/modificar/{idCategoria}")
    public String modificaCatalogo(Catalogo catalogo, Model model) {
        catalogo = catalogoService.getCatalogo(catalogo);
        model.addAttribute("catalogo",catalogo);
        return "redirect:/catalogo/listado";
    }
    
}

