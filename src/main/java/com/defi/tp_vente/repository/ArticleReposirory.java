package com.defi.tp_vente.repository;

import com.defi.tp_vente.modele.Article;
import com.defi.tp_vente.modele.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository

public interface
ArticleReposirory extends JpaRepository<Article,Integer> {
    @Modifying
    @Transactional
    @Query("Update Article a set a.qteStock=a.qteStock +:qte where a.id=:idArticle")
    void updateStockArticle(@Param("qte") int qte, @Param("idArticle") int idArticle);

    /*List<Article> findByName(String libelle);*/



}

