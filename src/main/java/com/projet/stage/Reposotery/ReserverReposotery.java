package com.projet.stage.Reposotery;

import com.projet.stage.Entity.Reserver;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReserverReposotery extends JpaRepository<Reserver, Long> {
    List<Reserver> findByClientId(Long id);
}
