package com.example.airportsystem.Services;

import com.example.airportsystem.Api.ApiException;
import com.example.airportsystem.Models.Plane;
import com.example.airportsystem.Repository.PlaneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaneService {

    private final PlaneRepository planeRepository;

    public List<Plane> getAll(){
        return planeRepository.findAll();
    }

    public void addPlane(Plane plane){
        planeRepository.save(plane);
    }

    public void updatePlane(Integer number, Plane plane){
        Plane oldPlane = planeRepository.findPlaneByNumber(number);

        if (oldPlane == null){
            throw new ApiException("No Plane found with number " + number);
        }

        oldPlane.setNumber(plane.getNumber());
        oldPlane.setName(plane.getName());
        oldPlane.setCapacity(plane.getCapacity());
        oldPlane.setType(plane.getType());
        planeRepository.save(oldPlane);
    }

    public Plane getPlaneByNumber(Integer number){
        Plane plane = planeRepository.findPlaneByNumber(number);

        if (plane==null){
            throw new ApiException("No Plane found with number " + number);
        }

        return plane;
    }

    public void deletePlane(Integer number){
        Plane plane = planeRepository.findPlaneByNumber(number);

        if (plane == null){
            throw new ApiException("No Plane found with number " + number);
        }

        planeRepository.delete(plane);
        planeRepository.save(plane);
    }

    public List<Plane> getPlaneByType(String type){
        List<Plane> planes = planeRepository.findPlaneByType(type);

       if (planes.isEmpty()){
           throw new ApiException("No Plane found with type " + type);
       }

       return planes;
    }


}


