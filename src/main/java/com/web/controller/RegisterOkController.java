package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegisterOkController {
    @GetMapping("/registerOk")
    public String inicio(Model model) {
        return "/users/registerOk";
    }
}
