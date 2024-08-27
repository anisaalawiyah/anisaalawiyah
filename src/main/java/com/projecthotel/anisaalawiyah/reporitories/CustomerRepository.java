package com.projecthotel.anisaalawiyah.reporitories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecthotel.anisaalawiyah.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @SuppressWarnings("null")
    List<Customer> findAll();
    // List<Customer> findbymerkCustomers(String tipe);
    Customer findByUsername(String username);
    Customer findByUsernameAndPassword(String username, String password);

    Customer findCustomerByEmail(String email);
    List<Customer> findByNameContainingIgnoreCase(String name);
    List<Customer> findAllByOrderByNameAsc();
    List<Customer> findAllByOrderByNameDesc();

    
}
