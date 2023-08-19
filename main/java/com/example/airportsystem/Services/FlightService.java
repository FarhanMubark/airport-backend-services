package com.example.airportsystem.Services;

import com.example.airportsystem.Api.ApiException;
import com.example.airportsystem.Models.Flight;
import com.example.airportsystem.Repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    final private FlightRepository flightRepository;

    public List<Flight> getAll(){
        return flightRepository.findAll();
    }

    public void addFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void updateFlight(Integer number, Flight flight){
        Flight oldFlight = flightRepository.findByNumber(number);

        if (oldFlight==null){
            throw new ApiException("No flight found with number" + number);
        }

        oldFlight.setNumber(flight.getNumber());
        oldFlight.setDate(flight.getDate());
        oldFlight.setGate_number(flight.getGate_number());
    }

    public void deleteFlight(Integer number){
        Flight flight = flightRepository.findByNumber(number);

        if (flight==null){
            throw new ApiException("No flight found with number" + number);
        }

        flightRepository.delete(flight);

    }

    public Flight getByGate(String gate){
        Flight flight = flightRepository.findFlightByGate_number(gate);

        if (flight==null){
            throw new ApiException("No flight for this gate number "+gate );
        }
        return flight;
    }

    public Flight getFlightByNumber(Integer number){
        Flight flight = flightRepository.findByNumber(number);

        if (flight==null){
            throw new ApiException("No flight found with number" + number);
        }

        return flight;
    }
}
