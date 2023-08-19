package com.example.airportsystem.Repository;

import com.example.airportsystem.Models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {

    Flight findByNumber(Integer number);
    Flight findFlightByGate_number(String gate);

}
