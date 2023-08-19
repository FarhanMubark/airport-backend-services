package com.example.airportsystem.Controllers;

import com.example.airportsystem.Api.ApiResponse;
import com.example.airportsystem.Models.Flight;
import com.example.airportsystem.Services.FlightService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/flight")
public class FlightController {

    private final FlightService flightService;

    @GetMapping("/get")
    public ResponseEntity getall(){
        return ResponseEntity.status(200).body(flightService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addFlight(@RequestBody @Valid Flight flight){
        flightService.addFlight(flight);
         return ResponseEntity.status(200).body(new ApiResponse("Flight Added"));
    }

    @PutMapping("/update/{number}")
    public ResponseEntity updateFlight(@PathVariable int number, @RequestBody Flight flight){
        flightService.updateFlight(number,flight);

        return ResponseEntity.status(200).body(new ApiResponse("Flight Updated"));
    }

    @DeleteMapping("/delete/{number}")
    public ResponseEntity deleteFlight(@PathVariable int number){
        flightService.deleteFlight(number);

        return ResponseEntity.status(200).body(new ApiResponse("Flight Deleted"));
    }
    @GetMapping("get-by-gate")
    public ResponseEntity getByGate(String gate){
        Flight flight = flightService.getByGate(gate);
        return ResponseEntity.status(200).body(flight);
    }

    @GetMapping("get-by-number/{number}")
    public  ResponseEntity getByNumber(int number){
        Flight flight = flightService.getFlightByNumber(number);
        return ResponseEntity.status(200).body(flight);
    }
}
