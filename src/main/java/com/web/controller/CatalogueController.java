package com.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/catalogue")
public class CatalogueController {

    //@Autowired
    //ClienteService clienteService;

        @GetMapping("/catalogs")
        public String inicio(Model model) {


            return "/catalogue/catalogs";
        }


    }
