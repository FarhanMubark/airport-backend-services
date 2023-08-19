package com.example.airportsystem.Services;

import com.example.airportsystem.Api.ApiException;
import com.example.airportsystem.Models.Passenger;
import com.example.airportsystem.Repository.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerService {
    final private PassengerRepository passengerRepository;

    public List<Passenger> getAll(){
        return passengerRepository.findAll();
    }

    public void addPassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }

    public void updatePassenger(Integer id, Passenger passenger){
        Passenger oldpass = passengerRepository.findPassengerById(id);

        if (oldpass==null){
            throw new ApiException("Passenger Not found with Id " + id);
        }

        oldpass.setName(passenger.getName());
        oldpass.setId(passenger.getId());
        oldpass.setCheckin(passenger.getCheckin());
//        oldpass.setFlight(passenger.getFlight());
        passengerRepository.save(oldpass);
    }

    public void deletePassenger(Integer id){
        Passenger passenger = passengerRepository.findPassengerById(id);

        if (passenger == null) {
            throw new ApiException("Passenger Not found with Id " + id);
        }

        passengerRepository.delete(passenger);
    }

    public Passenger findById(Integer id){
        Passenger passenger= passengerRepository.findPassengerById(id);

        if (passenger==null){
            throw new ApiException("Passenger Not found with Id " + id);
        }
        return passenger;
    }

    public void checkInPass(Integer id){
        Passenger passenger = passengerRepository.findPassengerById(id);
        if (passenger==null){
            throw new ApiException("Passenger Not found with Id " + id);
        }

        if (passenger.getCheckin()){
            throw new ApiException("The Passenger with this Id " + id + " is Already checkIn");
        }

        passenger.setCheckin(true);
        passengerRepository.save(passenger);

    }

    public List<Passenger> passengersBygender(String gender){
        List<Passenger> passengers = passengerRepository.findPassengersByGender(gender);

        if (passengers.isEmpty()){
            throw new ApiException("Not Valid gender");
        }

        return passengers;
    }

}
