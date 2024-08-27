package com.projecthotel.anisaalawiyah.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.projecthotel.anisaalawiyah.models.Customer;
import com.projecthotel.anisaalawiyah.reporitories.CustomerRepository;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/login-user")
    public String login() {
        return "login-user"; // Pastikan file ini ada di folder templates
    }

    @PostMapping("/login-user")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        Customer customer = customerRepository.findByUsername(username);
        if (customer != null && customer.getPassword().equals(password)) {
            session.setAttribute("customer", customer);
            if ("ADMIN".equals(customer.getRole())) {
                return "redirect:/admin";
            } else if ("USER".equals(customer.getRole())) {
                return "redirect:/home";
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "login-user"; // Pastikan file ini ada di folder templates
    }

    @GetMapping("/add-customer")
    public String showRegistrationForm() {
        return "add-customer"; // Pastikan file ini ada di folder templates
    }

    @PostMapping("/add-customer")
    public String register(@RequestParam String username, @RequestParam String password,
            @RequestParam String name, @RequestParam String address,@RequestParam String email, @RequestParam String phoneNumber,
            Model model) {
        if (customerRepository.findByUsername(username) != null) {
            model.addAttribute("error", "Username already exists");
            return "add-customer"; // Pastikan file ini ada di folder templates
        }
        Customer newCustomer = new Customer();
        newCustomer.setUsername(username);
        newCustomer.setPassword(password);
         newCustomer.setName(name); // Set name
         newCustomer.setAddress(address);
        newCustomer.setRole("USER"); // Default role is USER
        newCustomer.setEmail(email); // Set email
        newCustomer.setPhoneNumber(phoneNumber); // Set phone number
        customerRepository.save(newCustomer);
        model.addAttribute("message", "Registration successful, please login");
        return "redirect:/login-user"; // Pastikan file ini ada di folder templates
    }

    @GetMapping("/admin")
    public String adminHome(Model model, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null || !"ADMIN".equals(customer.getRole())) {
            return "redirect:/login-user";
        }
        model.addAttribute("message", "Welcome Admin!");
        return "admin"; // Pastikan file ini ada di folder templates
    }

    @GetMapping("/user")
    public String userHome(Model model, HttpSession session) {
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer == null || !"USER".equals(customer.getRole())) {
            return "redirect:/login-user";
        }
        model.addAttribute("message", "Welcome User!");
        return "Home"; // Pastikan file ini ada di folder templates
    }

    @GetMapping("/customer")
    public String allCustomer(Model model) {
        model.addAttribute("customer", customerRepository.findAll());
        return "show-customer";
    }

    @PostMapping("/save-customer")
    public String saveCustomers(Customer customer, Model model) {
        customerRepository.save(customer);
        return "login-user";
    }

    @PostMapping("/save-admin")
    public String saveCustomerAdmin(Customer customer) {
        customerRepository.save(customer);
        return "redirect:/customer";
    }

    @GetMapping("/update/{idCustomer}")
    public String updateCustomer(Model model, @PathVariable(value = "idCustomer") Integer idCustomer) {
        Customer customer = customerRepository.findById(idCustomer).orElse(null);
        model.addAttribute("customer", customer);
        return "update-customer";
    }

    @GetMapping("/delete/{id}")
    public String deletecustomer(@PathVariable(value = "id") Integer id) {
        customerRepository.deleteById(id);
        return "redirect:/customer";
    }

    @GetMapping("/searchCustomer")
    public String searchByName(@RequestParam(name = "searchCustomer") String name, Model model) {
        List<Customer> customers = customerRepository.findByNameContainingIgnoreCase(name);
        model.addAttribute("customer", customers);
        return "show-customer";
    }

    @GetMapping("/sort-by-name-asc")
    public String sortByNameAsc(Model model) {
        List<Customer> customers = customerRepository.findAllByOrderByNameAsc();
        model.addAttribute("customer", customers);
        return "show-customer";
    }

    @GetMapping("/sort-by-name-desc")
    public String sortByNameDesc(Model model) {
        List<Customer> customers = customerRepository.findAllByOrderByNameDesc();
        model.addAttribute("customer", customers);
        return "show-customer";
    }

}
