package com.projet.stage.Reposotery;

import com.projet.stage.Entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitReposotery extends JpaRepository<Produit,Long> {
}
