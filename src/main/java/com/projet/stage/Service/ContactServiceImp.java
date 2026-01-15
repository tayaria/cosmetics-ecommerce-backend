package com.projet.stage.Service;

import com.projet.stage.Entity.Contact;

import com.projet.stage.Reposotery.ContactReposotery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ContactServiceImp implements ContactService {
    @Autowired
    ContactReposotery contactReposotery;
    @Override
    public Contact AjouterContact(Contact contact) {
        return contactReposotery.save(contact) ;
    }

    @Override
    public Contact ModifierContact(Contact contact) {
        return contactReposotery.save(contact);
    }

    @Override
    public List<Contact> AfficherContacts() {
        return contactReposotery.findAll();
    }

    @Override
    public void SupprimerContact(Long id) {
            contactReposotery.deleteById(id);
    }

    @Override
    public Optional<Contact> AffichierContactById(Long id) {
        return contactReposotery.findById(id);
    }
}
