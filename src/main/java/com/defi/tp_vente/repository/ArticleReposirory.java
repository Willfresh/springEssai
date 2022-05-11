package com.defi.tp_vente.repository;

import com.defi.tp_vente.modele.Article;
import com.defi.tp_vente.modele.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleReposirory extends JpaRepository<Article,Integer> {
}
