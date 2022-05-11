package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.Article;
import com.defi.tp_vente.modele.Categorie;
import com.defi.tp_vente.repository.ArticleReposirory;
import com.defi.tp_vente.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleReposirory articleRepository;
    public void saveArticle(Article article){
        articleRepository.save(article);
    }

    public List<Article> showAllArticles(){
        return articleRepository.findAll();
    }

    public Article showOneArticle(int id){

        return articleRepository.findById(id).get();
    }

    public void deleteArticle(int id){
        articleRepository.deleteById(id);
    }
}
