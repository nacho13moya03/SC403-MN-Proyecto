/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto_Controller;

import com.Proyecto.Domain.Producto;
import com.Proyecto.Service.CatalogoService;
import com.Proyecto.Service.ProductoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ProductoController {
    @Autowired
    private ProductoService articuloService;
    @Autowired
    private CatalogoService catalogoService;
    
    @GetMapping("/producto/listado")
    public String inicio(Model model){
        var productos = articuloService.getProducto(false);
        model.addAttribute("articullos",productos);
        return "/producto/listado";
    }
    
    @GetMapping("/producto/nuevo")
    public String nuevoProducto(Producto producto, Model model){
        var catalogos = catalogoService.getCatalogo(true);
        model.addAttribute("catalogos",catalogos);
        return "producto/modificar";
    }
    
    @PostMapping("/producto/guardar")
    public String guardarProducto(Producto producto){
        articuloService.save(producto);
        return "producto/modificar";
    }
    
    @GetMapping("/producto/modificar/{idArticulo}")
    public String modificarProducto(Producto producto, Model model){
        producto = articuloService.getProducto(producto);
        var catalogos = catalogoService.getCatalogo(true);
        model.addAttribute("catalogos",catalogos);
        model.addAttribute("productos",producto);
        return "producto/modificar";
    }
    
    @GetMapping("/producto/eliminar/{idArticulo}")
    public String eliminarProducto(Producto producto){
        articuloService.delete(producto);
        return "redirect:/producto/listado";
    }
}
