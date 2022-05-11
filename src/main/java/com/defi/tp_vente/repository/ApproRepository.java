package com.defi.tp_vente.repository;

import com.defi.tp_vente.modele.Appro;
import com.defi.tp_vente.modele.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproRepository extends JpaRepository<Appro,Integer> {
}
