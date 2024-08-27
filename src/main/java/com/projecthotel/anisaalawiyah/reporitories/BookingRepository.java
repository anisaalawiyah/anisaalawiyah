package com.projecthotel.anisaalawiyah.reporitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecthotel.anisaalawiyah.models.Booking;

public  interface BookingRepository extends JpaRepository<Booking,Integer> {

    // List<Booking> findByDateContainingIgnoreCase(LocalDate checkInDate);
  
    List<Booking> findAllByOrderByCheckInDateDesc();
    List<Booking> findAllByOrderByCheckInDateAsc();
}
