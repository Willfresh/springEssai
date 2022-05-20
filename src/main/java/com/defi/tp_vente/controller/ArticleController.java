package com.defi.tp_vente.controller;

import com.defi.tp_vente.modele.Article;
import com.defi.tp_vente.modele.Constante;
import com.defi.tp_vente.repository.ArticleReposirory;
import com.defi.tp_vente.service.ArticleService;
import com.defi.tp_vente.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private CategorieService categorieService;
    @Autowired
    private ArticleService articleService;

    @GetMapping("/articlesShow")
    public String showAllArticles(Model model){
        model.addAttribute("listeArticle",articleService.changerEtatArticle( articleService.showAllArticles()));
        //pas obligé d'avoir le mm nom que le return
        return "admin/ListesArticles";
    }

    @GetMapping("/articlesForm")
    public String ShowFormArticle(Model model){
        model.addAttribute("listeCategorie",categorieService.showAllCategories());
        return "admin/FormArticles";
    }
    @PostMapping("/articles/save")
    public String saveArticle(Article article){
        article.setQteStock(0);
        article.setDateCreation(LocalDate.now());
        articleService.saveArticle(article);
        return "redirect:/articlesShow";
    }

    @GetMapping("/articleEdit{id}")
    public String formEdit(@PathVariable("id") int id, Model model){
        model.addAttribute("Un_article",articleService.showOneArticle(id));
        model.addAttribute("listeCategorie",categorieService.showAllCategories());
        return "admin/FormEdit";
    }
    @PostMapping("articles/update")
     public  String updateArticle(@ModelAttribute("article") Article article){
        articleService.saveArticle(article);
        return "redirect:/articlesShow";

     }
    @GetMapping("/article/delete/{id}")
    public String deleteArticle(@PathVariable("id") int id){
        articleService.deleteArticle(id);
        return "redirect:/articlesShow";

    }
    @GetMapping("/articlesEtatSeuil")
    public String listeSeuil(Model model){
        model.addAttribute("listeSeuil",articleService.articleEtatCritique(articleService.showAllArticles()));
        return "admin/ListeSeuil";
    }

   /*
    public Article<List<Article>> getArticleByName(@RequestParam String libelle){
        return new Article<List<Article>>(arti)
    }*/
}
