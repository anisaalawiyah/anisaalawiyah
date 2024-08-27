package com.projecthotel.anisaalawiyah.reporitories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecthotel.anisaalawiyah.models.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    
}
