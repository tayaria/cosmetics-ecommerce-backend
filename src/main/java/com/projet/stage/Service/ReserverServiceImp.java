package com.projet.stage.Service;

import com.projet.stage.Entity.Client;
import com.projet.stage.Entity.Produit;
import com.projet.stage.Entity.Reserver;

import com.projet.stage.Entity.ReserverRq;
import com.projet.stage.Reposotery.ReserverReposotery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReserverServiceImp implements ReserverService {
    @Autowired
    ReserverReposotery reserverReposotery;
    @Autowired
    ProduitService produitService;
    @Autowired
    ClientService clientService;

    @Override
    public Reserver AjouterReservation(ReserverRq reserverRq) {
        Optional<Produit> produit = produitService.AffichierProduitById(reserverRq.getIdProduit());
        Optional<Client> client = clientService.AffichierClientById(reserverRq.getIdClient());
        if (produit.isPresent() && client.isPresent()) {
            Reserver reserver = new Reserver();
            reserver.setProduit(produit.get());
            reserver.setClient(client.get());
            return reserverReposotery.save(reserver);
        }
        else
        {
            return null;
        }
    }



    @Override
    public List<Reserver> AfficherReservations() {
        return reserverReposotery.findAll();
    }

    @Override
    public List<Reserver> AfficherProduitByClient(Long id) {
        return reserverReposotery.findByClientId(id);
    }


    @Override
    public Optional<Reserver> AffichierReservationById(Long id) {
        return reserverReposotery.findById(id);
    }
}
