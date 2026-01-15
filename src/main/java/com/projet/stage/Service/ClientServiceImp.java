package com.projet.stage.Service;

import com.projet.stage.Entity.Client;
import com.projet.stage.Reposotery.AdminReposotery;
import com.projet.stage.Reposotery.ClientReposotery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ClientServiceImp implements ClientService {
    @Autowired
    ClientReposotery clientReposotery;
    @Override
    public Client AjouterClient(Client client) {
        return clientReposotery.save(client);
    }

    @Override
    public Client ModifierClient(Client client) {
        return clientReposotery.save(client);
    }

    @Override
    public List<Client> AfficherClients() {
        return clientReposotery.findAll();
    }

    @Override
    public void SupprimerClient(Long id) {
        clientReposotery.deleteById(id);
    }

    @Override
    public Optional<Client> AffichierClientById(Long id) {
        return clientReposotery.findById(id);
    }
}
