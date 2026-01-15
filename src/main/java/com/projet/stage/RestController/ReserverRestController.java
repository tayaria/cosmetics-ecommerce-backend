package com.projet.stage.RestController;

import com.projet.stage.Entity.Reserver;
import com.projet.stage.Entity.ReserverRq;
import com.projet.stage.Service.ReserverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping(value = "/reservation")
@RestController
@CrossOrigin("*")
public class ReserverRestController {
    @Autowired
    ReserverService reserverService;
    @RequestMapping(method = RequestMethod.POST)
    public Reserver ajouterReservation(@RequestBody ReserverRq reserverRq){
        System.out.println("reserverRq"+reserverRq);
        return reserverService.AjouterReservation(reserverRq);
    }
    @RequestMapping("get-all-by-id-Client/{id}")
    public List<Reserver> listReservationByClient(@PathVariable Long id){
        return reserverService.AfficherProduitByClient(id);
    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Reserver> afficherReserver(){
        return reserverService.AfficherReservations();
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Optional<Reserver> getReservationById(@PathVariable("id") long id){

        Optional<Reserver> reservation = reserverService.AffichierReservationById(id);
        return reservation;
    }
}
