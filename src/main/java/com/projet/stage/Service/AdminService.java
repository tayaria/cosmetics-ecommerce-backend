package com.projet.stage.Service;

import com.projet.stage.Entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    Admin AjouterAdmin(Admin admin);
    Admin ModifierAdmin(Admin admin);
    List<Admin> AfficherAdmins();
    void SupprimerAdmin(Long id);
    Optional<Admin> AffichierAdminById(Long id);
}
