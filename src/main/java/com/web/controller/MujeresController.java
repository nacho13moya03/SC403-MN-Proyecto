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


  @GetMapping("/mujeres")
   public String inicio(Model model) {

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
}
