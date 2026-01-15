package com.projet.stage.Reposotery;

import com.projet.stage.Entity.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminReposotery extends JpaRepository<Admin,Long> {
    Admin findAdminByEmail(String email);

    boolean existsByEmail(String email);
}
