package com.example.airportsystem.Controllers;

import com.example.airportsystem.Api.ApiResponse;
import com.example.airportsystem.Models.Waiting_Room;
import com.example.airportsystem.Services.Waiting_Room_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("api/v1/room")
@RequiredArgsConstructor
public class Waiting_Room_Controller {
    final private Waiting_Room_Service roomService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(roomService.getall());
    }

    @PostMapping("/add")
    public ResponseEntity addRoom(@RequestBody Waiting_Room room){
        roomService.addWaitingRoom(room);
        return ResponseEntity.status(200).body(new ApiResponse("Room added"));
    }

    @PutMapping("/update/{number}")
    public ResponseEntity updateRoom(@PathVariable int number, @RequestBody Waiting_Room room){
        roomService.updateRoom(number, room);
        return ResponseEntity.status(200).body(new ApiResponse("Room updated"));
    }

    @DeleteMapping("/delete/{number}")
    public ResponseEntity deleteRoom(@PathVariable int number){
        roomService.deleteRoom(number);
        return ResponseEntity.status(200).body(new ApiResponse("Room deleted"));
    }

    @GetMapping("/get-more100")
    public ResponseEntity getseats(){
        return ResponseEntity.status(200).body(roomService.findmore100seat());
    }

    @GetMapping("/get-all-bytype/{type}")
    public ResponseEntity getAllByType(@PathVariable String type){
        List<Waiting_Room> rooms = roomService.getallByType(type);
        return ResponseEntity.status(200).body(rooms);
    }

}
