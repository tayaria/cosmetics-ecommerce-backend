package com.projet.stage.Service;


import com.projet.stage.Entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client AjouterClient(Client client);
    Client ModifierClient(Client client);
    List<Client> AfficherClients();
    void SupprimerClient(Long id);
    Optional<Client> AffichierClientById(Long id);
}
