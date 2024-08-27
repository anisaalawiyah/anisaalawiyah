package com.projecthotel.anisaalawiyah.reporitories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projecthotel.anisaalawiyah.models.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByStatus(String status);
    List<Room> findByTypeContainingIgnoreCase(String type);
    List<Room> findAllByOrderByTypeAsc();
    List<Room> findAllByOrderByTypeDesc();

    
   
    
   

}