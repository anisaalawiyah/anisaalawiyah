// package com.projecthotel.anisaalawiyah.controllers;


// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;

// import com.projecthotel.anisaalawiyah.models.Admin;
// import com.projecthotel.anisaalawiyah.reporitories.AdminRepository;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;



// @Controller
// public class AdminController {
//     @Autowired
//     AdminRepository adminRepository;

//     @GetMapping("admin")
//     public String getMethodName(Model model) {
//         Admin admin =new Admin();
//         model.addAttribute("admin",admin );
//         return"admin";

//     }

//     @GetMapping("/add-admin")
//     public String  addAdmin(Model model) {
//         Admin admin = new Admin();
//         model.addAttribute("admin", admin);
//         return"Login";
//     }
    
//     @GetMapping("/cek-login")
//     public String ceklogin(@ModelAttribute("admin") Admin inputAdmin, Model model) {
//         Admin referenceAdmin = adminRepository.findById(1).orElse(null);
    
//         if (referenceAdmin != null &&
//                 referenceAdmin.getUsername().equals(inputAdmin.getUsername()) &&
//                 referenceAdmin.getPassword().equals(inputAdmin.getPassword())) {
//             return "redirect:/admin";
//         }
       
        
//         // Jika tidak ada kecocokan, tetapkan atribut error dan kembali ke halaman login
//         model.addAttribute("error", "Username atau password salah");
//         return "Login";
//     }
    
    
    
    
    
// }
