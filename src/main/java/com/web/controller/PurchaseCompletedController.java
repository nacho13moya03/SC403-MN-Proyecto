package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/extras")
public class PurchaseCompletedController {
    @GetMapping("/PurchaseCompleted")
    public String inicio(Model model) {
        return "/extras/PurchaseCompleted";
    }
}