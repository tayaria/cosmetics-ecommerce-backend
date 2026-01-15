package com.projet.stage.Reposotery;

import com.projet.stage.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientReposotery extends JpaRepository<Client,Long> {
    boolean existsByEmail(String email);

    Client findClientByEmail(String email);
}
