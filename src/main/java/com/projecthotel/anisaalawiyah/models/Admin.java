package com.projecthotel.anisaalawiyah.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Admin {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id;
private String username;
private String password;
public Integer getId() {
    return id;
}
public String getUsername() {
    return username;
}
public String getPassword() {
    return password;
}
public void setId(Integer id) {
    this.id = id;
}
public void setUsername(String username) {
    this.username = username;
}
public void setPassword(String password) {
    this.password = password;
}



    
    
}
