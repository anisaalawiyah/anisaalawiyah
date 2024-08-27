package com.projecthotel.anisaalawiyah.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projecthotel.anisaalawiyah.models.Room;
import com.projecthotel.anisaalawiyah.reporitories.RoomRepository;

@Service
public class RoomServies {
    @Autowired
    private RoomRepository roomRepository;
    public void simpanGambar(Room room) {
        roomRepository.save(room);
    }

    public Room dapatkanGambar(Integer id) {
        return roomRepository.findById(id).orElse(null);
        
    }
    
}
