package com.defi.tp_vente.service;

import com.defi.tp_vente.modele.Article;
import com.defi.tp_vente.modele.Constante;
import com.defi.tp_vente.repository.ArticleReposirory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public void updateStockArticle(int qte, int id){
        articleRepository.updateStockArticle(qte, id);}

    public List<Article> changerEtatArticle(List<Article> liste){
        for (Article a:liste){
            if (a.getQteSeuil()>a.getQteStock()){
                a.setEtat(Constante.ETAT_CRITIQUE);
            }
            else{
                a.setEtat(Constante.ETAT_NORMAL);
            }
        }
        return liste;
    }

    public List<Article> articleEtatCritique(List<Article> liste){
        List<Article> listeSeuil=new ArrayList<>();
        for (Article a:liste){
            if (a.getQteSeuil()>a.getQteStock()){
                listeSeuil.add(a);
            }
        }
        return listeSeuil;
    }
    /*public List<Article> findByName(List<Article> liste){
        List<Article> listeName = new ArrayList<>();
        for (Article a:liste){
            if(a.getLibelle()=a.)
        }
    }*/

}
