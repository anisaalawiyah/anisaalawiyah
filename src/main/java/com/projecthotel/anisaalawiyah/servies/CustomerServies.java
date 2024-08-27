package com.projecthotel.anisaalawiyah.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecthotel.anisaalawiyah.models.Customer;
import com.projecthotel.anisaalawiyah.reporitories.CustomerRepository;

@Service
public class CustomerServies {
    @Autowired 
    private CustomerRepository customerRepository;
    public Customer findEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }
}

