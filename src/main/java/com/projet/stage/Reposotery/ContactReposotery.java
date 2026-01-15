package com.projet.stage.Reposotery;

import com.projet.stage.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactReposotery extends JpaRepository<Contact, Long> {
}
