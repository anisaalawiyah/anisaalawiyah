package com.projecthotel.anisaalawiyah.models;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRoom;
    @Column(length = 64)
    private String image;
    private String type;
    private String size;
    private Integer price;
    private String status;

  // @OneToMany(mappedBy = "idRoom")
  //  private List<Booking> booking;

   
}
