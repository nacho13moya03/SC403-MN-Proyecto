package com.web.controller;

import com.web.dao.ArticuloDao;
import com.web.domain.Articulo;
import com.web.domain.Categoria;
import com.web.domain.Cliente;
import com.web.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/catalogue")
public class MujeresController {
    @Autowired
    ArticuloService articuloService;
   /* @GetMapping("/mujeres")
    public String inicio(Model model) {
       //Articulo articulo = articuloService.getArticuloByCategoria();
       model.addAttribute("articulo", articulo);
       var articulos = articuloService.getArticulosCatalogos();
        for (var a:articulos) {
            if (a.getCategoria()==3) {
                model.addAttribute("articulos", articulos);
            }
        }
        return "mujeres";
    }*/


  @GetMapping("/mujeres")
   public String inicio(Model model) {
     /* var articulos = articuloService.getArticuloCatalogo(articulo);
      Long cat = articulos.getCategoria().getIdCategoria();
      if(cat==3L){
          model.addAttribute("articulos", articulos);
      }*/

      var articulos = articuloService.getArticulosCatalogos();
      List art = new ArrayList(); ;
      //model.addAttribute("articulos", articulos);
      //var articulos = articuloService.getArticuloCatalogo(art.);
     /* var articulos = articuloService.getArticuloCatalogo(art);
      Long cat = articulos.getCategoria().getIdCategoria();*/
      for (var a:articulos) {
          if (a.getCategoria().getIdCategoria()==3L) {
              art.add(a);
          }
      }
      model.addAttribute("art", art);
     /* List<Articulo> articulosCategoria3 = articuloDao.findByCategoria(3L);
      model.addAttribute("articulosCategoria3", articulosCategoria3);
      /* var articulos = articuloService.getArticulosCatalogos();
       model.addAttribute("articulos", articulos);
       model.addAttribute("totalArticulos",articulos.size());*/
       return "mujeres";
   }
}
