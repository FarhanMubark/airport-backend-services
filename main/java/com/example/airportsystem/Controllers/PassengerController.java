package com.example.airportsystem.Controllers;

import com.example.airportsystem.Api.ApiResponse;
import com.example.airportsystem.Models.Passenger;
import com.example.airportsystem.Services.PassengerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/passenger")
@RequiredArgsConstructor
public class PassengerController {

    final private PassengerService passengerService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(passengerService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addPass(@RequestBody @Valid Passenger passenger){
        passengerService.addPassenger(passenger);

        return ResponseEntity.status(200).body("Passenger Added !");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updatePass(@PathVariable int id, @RequestBody @Valid Passenger passenger){
        passengerService.updatePassenger(id,passenger);
        return ResponseEntity.status(200).body(new ApiResponse("Passenger updated !"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletePass(@PathVariable int id){
        passengerService.deletePassenger(id);
        return ResponseEntity.status(200).body(new ApiResponse("Passenger Deleted !"));
    }

    @PutMapping("/check-in-pass/{id}")
    public ResponseEntity passCheckIn(@PathVariable int id){
        passengerService.checkInPass(id);
        return ResponseEntity.status(200).body(new ApiResponse("Passenger checkIn Succufully"));
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity getById(@PathVariable int id){
        Passenger passenger = passengerService.findById(id);

        return ResponseEntity.status(200).body(passenger);
    }

    @GetMapping("/get-all-bygender/{gender}")
    public ResponseEntity getpassengersByGender(String gender){
        List<Passenger> passengers = passengerService.passengersBygender(gender);
        return ResponseEntity.status(200).body(passengers);
    }

}
