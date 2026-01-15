package com.projet.stage.Service;



import com.projet.stage.Entity.Reserver;
import com.projet.stage.Entity.ReserverRq;

import java.util.List;
import java.util.Optional;

public interface ReserverService {
     Reserver AjouterReservation(ReserverRq reserverRq);

    List<Reserver> AfficherReservations();
    List<Reserver> AfficherProduitByClient(Long id);

    Optional<Reserver> AffichierReservationById(Long id);
}
