package com.defi.tp_vente.controller;

import com.defi.tp_vente.modele.Vente;
import com.defi.tp_vente.service.ArticleService;
import com.defi.tp_vente.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class VenteController {
    @Autowired
    private VenteService venteService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/vente/show")
    public String showAllVente(Model model){
        model.addAttribute("listeVente",venteService.showAllVente());
        //pas obligé d'avoir le mm nom que le return
        return "vente/ListeVente";
    }
    @GetMapping("/vente/form")
    public String ShowFormVente(Model model){
        model.addAttribute("listeVente",articleService.showAllArticles());
        return "vente/FormVente";
    }
    @PostMapping("/vente/save")
    public String saveVente(Vente vente){
        vente.setQteVente(vente.getQteVente());
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        return "redirect:/vente/show";
    }
    @GetMapping("/vente/edit/{id}")
    public String venteEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Une_vente",venteService.showOnevente(id));
        model.addAttribute("listeVente",articleService.showAllArticles());
        return "vente/venteEdit";
    }
    @PostMapping("vente/update")
    public  String updateVente(@ModelAttribute("vente") Vente vente){
        venteService.saveVente(vente);
        return "redirect:/vente/show";

    }
    @GetMapping("/vente/delete/{id}")
    public String deleteVente(@PathVariable("id") int id){
        venteService.deleteVente(id);
        return "redirect:/vente/show";

    }


}
