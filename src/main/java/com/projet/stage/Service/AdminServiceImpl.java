package com.projet.stage.Service;

import com.projet.stage.Entity.Admin;
import com.projet.stage.Reposotery.AdminReposotery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminReposotery adminReposotery;
    @Override
    public Admin AjouterAdmin(Admin admin) {
        return adminReposotery.save(admin);
    }

    @Override
    public Admin ModifierAdmin(Admin admin) {
        return adminReposotery.save(admin);
    }

    @Override
    public List<Admin> AfficherAdmins() {
        return adminReposotery.findAll();
    }

    @Override
    public void SupprimerAdmin(Long id) {
        adminReposotery.deleteById(id);
    }

    @Override
    public Optional<Admin> AffichierAdminById(Long id) {
        return adminReposotery.findById(id);
    }
}
