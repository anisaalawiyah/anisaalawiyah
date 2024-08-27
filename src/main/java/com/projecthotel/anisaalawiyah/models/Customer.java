package com.projecthotel.anisaalawiyah.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCustomer;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;
    private String password;
    private String username;
    private String role;

    
   @OneToMany(mappedBy = "idCustomer")
    private List<Booking> booking;

    
}
