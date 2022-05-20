package com.defi.tp_vente.controller;

import com.defi.tp_vente.modele.Categorie;
import com.defi.tp_vente.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategorieController {
    @Autowired
    private CategorieService categorieService;
    @GetMapping("/categoriesShow")
    public String showAllCategories(Model model){
        model.addAttribute("listeCategorie",categorieService.showAllCategories());
        //pas obligé d'avoir le mm nom que le return
        return "admin/ListeCategories";
    }
    @GetMapping("/categorieForm")
    public String showFormCategorie(){
        return "admin/FormCategories";
    }
    @PostMapping("/categorie/save")
    public String saveCategorie(Categorie categorie){
        categorieService.saveCategorie(categorie);
        return "redirect:/categoriesShow";
    }
}
