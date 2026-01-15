package com.projet.stage.Service;


import com.projet.stage.Entity.Produit;

import java.util.List;
import java.util.Optional;

public interface ProduitService {
    Produit AjouterProduit(Produit client);
    Produit ModifierProduit(Produit client);
    List<Produit> AfficherProduits();
    void SupprimerProduit(Long id);
    Optional<Produit> AffichierProduitById(Long id);

}
