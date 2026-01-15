package com.projet.stage.RestController;


import com.projet.stage.Entity.Produit;
import com.projet.stage.Service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/produit")
@RestController
@CrossOrigin("*")
public class ProduitRestController {

    @Autowired
    ProduitService produitService;
    @RequestMapping(method = RequestMethod.POST )
    public Produit AjouterProduit (@RequestBody Produit produit) {
        return produitService.AjouterProduit(produit);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )

    public void suppAdmin(@PathVariable("id") Long id){
        produitService.SupprimerProduit(id);

    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Produit> afficherProduit(){
        return produitService.AfficherProduits();

    }

}
