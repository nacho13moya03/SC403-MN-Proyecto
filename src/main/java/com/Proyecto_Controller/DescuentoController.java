/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Controller;

import com.Proyecto.Domain.Descuento;
import com.Proyecto.Service.DescuentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Adriana Ramirez
 */
@Controller
@Slf4j
public class DescuentoController {
    @Autowired
    DescuentoService descuentoService;
    
    @GetMapping("/descuento/listado")
    public String inicio(Model model) {
        var descuentos = descuentoService.getDescuento(false);
        model.addAttribute("descuento", descuentos);
        return "/descuento/listado";    
    }
    
    @GetMapping("/descuento/nuevo")
    public String nuevoDescuento(Descuento descuento) {
        return "/descuento/modificar";
    }
    
    @PostMapping("/descuento/guardar")
    public String guardaDescuento(Descuento descuento) {
        descuentoService.save(descuento);
        return "redirect:/descuento/listado";
    }
    
    
    @GetMapping("/descuento/eliminar/{id_descuento}")
    public String eliminarDescuento(Descuento descuento) {
        descuentoService.delete(descuento);
        return "redirect:/catalogo/listado";
    }
    
    @GetMapping("/descuento/modificar/{id_descuento}")
    public String modificaDescuento(Descuento descuento, Model model) {
        descuento = descuentoService.getDescuento(descuento);
        model.addAttribute("descuento",descuento);
        return "redirect:/descuento/listado";
    }
    
}
