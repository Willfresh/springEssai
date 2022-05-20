package com.defi.tp_vente;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {
    @GetMapping("/home")
    public String getHome(){
        return "admin/index";
    }
}
