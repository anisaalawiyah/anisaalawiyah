package com.projecthotel.anisaalawiyah.controllers;

import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.projecthotel.anisaalawiyah.models.Room;
import com.projecthotel.anisaalawiyah.reporitories.RoomRepository;



@Controller
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    public static Integer tampungId=0;
 
    @GetMapping("/Room")
    public String dataRoom(Model model) {
        List<Room> Rooms = roomRepository.findByStatus("tersedia");
        model.addAttribute("room", Rooms);
        return "show-room";
    }
     @GetMapping("/admin-room")
    public String AdminRoom(Model model) {
       model.addAttribute("room",roomRepository.findAll());
        return "admin-room";
    }

  
    @GetMapping("/add-room")
    public String addRoom(Model model) {
        Room room = new Room();
        model.addAttribute("room", room);
        // model.addAttribute("customer",customerRepository.findAll());
        return "add-room";
    }

   
    @PostMapping("/save-room")
    public String saveRoom(Room room,@RequestPart("file") MultipartFile multipartFile) {
        try {
            Path targetPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static",
            multipartFile.getOriginalFilename());
            multipartFile.transferTo(targetPath.toFile());
            String url = "http://localhost:8080/" + multipartFile.getOriginalFilename();
            room.setImage(url);
            roomRepository.save(room);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/admin-room";
    }

    @GetMapping("/update-room/{idRoom}")
    public String updateRoom(@PathVariable(value = "idRoom") Integer idRoom, Model model) {
        // Use findById to get a managed entity
        Room room = roomRepository.getReferenceById(idRoom);
        model.addAttribute("room", room);
        return "update-room";
    }


    @PostMapping("/update-Room")
        public String saveUpdatedRoom(
            @RequestParam("idRoom") Integer idRoom,
            @RequestParam("type") String type,
            @RequestParam("status") String status,
            @RequestParam("size") String size,
            @RequestParam("price") Integer price,
            @RequestPart("image") MultipartFile multipartFile) {
        Room existingRoom = roomRepository.findById(idRoom).orElse(null);

        if (existingRoom != null) {
            existingRoom.setType(type);
            existingRoom.setStatus(status);
            existingRoom.setSize(size);
            existingRoom.setPrice(price);

            try {
                if (!multipartFile.isEmpty()) {
                    // If a new image is provided, update the image
                    Path targetPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "static",
                    multipartFile.getOriginalFilename());
                    multipartFile.transferTo(targetPath.toFile());
                    String url = "http://localhost:8080/" + multipartFile.getOriginalFilename();
                    existingRoom.setImage(url);
                }

                roomRepository.save(existingRoom);
            } catch (IOException e) {
                e.printStackTrace();
                return "redirect:/error";
            }
        }
        
        return "redirect:/admin-room";
    }


    @GetMapping("delete-room/{idRoom}")
    public String delete(@PathVariable(value = "idRoom") Integer idRoom) {
        roomRepository.deleteById(idRoom);
        return "redirect:/admin-room";
    }
    
    @GetMapping("/pesan/{id}")
    public String pesan(@PathVariable Integer id)  {
        // Mengambil room berdasarkan ID
        // Room room = roomRepository.findById(id).orElse(null);
        tampungId=id;

        // System.out.println(tampungId);
        // Memperbarui status room menjadi tidak tersedia
        // if (room != null) {
        //     room.setStatus("tidak tersedia");
        //     roomRepository.save(room);
        // }
        // Tambahkan logika lain yang diperlukan, seperti pindah ke halaman pemesanan
        return "redirect:/add-booking";
    }
    
    

    @GetMapping("/search")
    public String searchByType(@RequestParam (name= "search") String type,Model model) {
        List<Room> rooms = roomRepository.findByTypeContainingIgnoreCase(type);
        model.addAttribute("room", rooms);
        return "admin-room";
    }

    @GetMapping("/sort-by-type-asc")
    public String sortByMerkAsc (Model model) {
        List<Room> rooms =roomRepository.findAllByOrderByTypeAsc();
        model.addAttribute("room", rooms);
        return "admin-room";
    }
    @GetMapping("/sort-by-type-desc")
    public String sortByMerkDesc (Model model) {
        List<Room> rooms =roomRepository.findAllByOrderByTypeDesc();
        model.addAttribute("room", rooms);
        return "admin-room";
    }

   
    
}