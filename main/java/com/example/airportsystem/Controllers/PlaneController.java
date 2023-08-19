package com.example.airportsystem.Controllers;

import com.example.airportsystem.Api.ApiResponse;
import com.example.airportsystem.Models.Plane;
import com.example.airportsystem.Services.PlaneService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/plane")
public class PlaneController {

    final private PlaneService planeService;

    @GetMapping("/get")
    public ResponseEntity getAll(){

        return ResponseEntity.status(200).body(planeService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addPlane(@RequestBody @Valid Plane plane){
        planeService.addPlane(plane);
        return ResponseEntity.status(200).body(new ApiResponse("Plane Added"));
    }

    @PutMapping("/update/{number}")
    public ResponseEntity updatePlane(@PathVariable int number, @RequestBody @Valid Plane plane){
        planeService.updatePlane(number,plane);
        return ResponseEntity.status(200).body(new ApiResponse("Plane Updated"));
    }

    @GetMapping("/get-by-type/{type}")
    public ResponseEntity getbyType(@PathVariable String type){
        List<Plane> plane = planeService.getPlaneByType(type);

        return ResponseEntity.status(200).body(plane);
    }

    @DeleteMapping("/delete/{number}")
    public ResponseEntity deletePlane(Integer number){
        planeService.deletePlane(number);
        return ResponseEntity.status(200).body(new ApiResponse("Plane Deleted"));
    }

    @GetMapping("/get-by-number/{number}")
    public ResponseEntity getByNumber(int number){
        Plane plane = planeService.getPlaneByNumber(number);

        return ResponseEntity.status(200).body(plane);
    }



}
