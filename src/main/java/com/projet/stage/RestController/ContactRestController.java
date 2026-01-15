package com.projet.stage.RestController;

import com.projet.stage.Entity.Admin;
import com.projet.stage.Entity.Contact;
import com.projet.stage.Reposotery.AdminReposotery;
import com.projet.stage.Service.AdminService;
import com.projet.stage.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
@RequestMapping(value = "/contact")
@RestController
@CrossOrigin("*")

public class ContactRestController {



    @Autowired
    ContactService contactService;
    @RequestMapping(method = RequestMethod.POST )
    public Contact AjouterContact (@RequestBody Contact contact) {
       return contactService.AjouterContact(contact);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE )

    public void suppAdmin(@PathVariable("id") Long id){
        contactService.SupprimerContact(id);

    }
    @RequestMapping(method = RequestMethod.GET )
    public List<Contact> afficherAdmin(){
        return contactService.AfficherContacts();

    }


}
