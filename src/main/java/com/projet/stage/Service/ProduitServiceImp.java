package com.projet.stage.Service;

import com.projet.stage.Entity.Produit;
import com.projet.stage.Reposotery.ClientReposotery;
import com.projet.stage.Reposotery.ProduitReposotery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProduitServiceImp implements ProduitService {
    @Autowired
    ProduitReposotery produitReposotery;
    @Override
    public Produit AjouterProduit(Produit client) {
        return produitReposotery.save(client);
    }

    @Override
    public Produit ModifierProduit(Produit client) {
        return produitReposotery.save(client);
    }

    @Override
    public List<Produit> AfficherProduits() {
        return produitReposotery.findAll();
    }

    @Override
    public void SupprimerProduit(Long id) {
        produitReposotery.deleteById(id);
    }

    @Override
    public Optional<Produit> AffichierProduitById(Long id) {
        return produitReposotery.findById(id);
    }
}
