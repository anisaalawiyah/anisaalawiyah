package com.projecthotel.anisaalawiyah.models;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBooking;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Integer duration;
    private Integer totalPemesanan;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name="id_customer",referencedColumnName = "idCustomer")
    private Customer idCustomer;

    @ManyToOne
    @JoinColumn( name="id_room",referencedColumnName = "idRoom")
    private Room idRoom;

   
   
   

    
    
}
