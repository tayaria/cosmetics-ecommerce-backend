package com.projet.stage.Service;



import com.projet.stage.Entity.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact AjouterContact(Contact contact);
    Contact ModifierContact(Contact contact);
    List<Contact> AfficherContacts();
    void SupprimerContact(Long id);
    Optional<Contact> AffichierContactById(Long id);
}
