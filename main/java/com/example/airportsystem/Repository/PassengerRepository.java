package com.example.airportsystem.Repository;

import com.example.airportsystem.Models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {

    Passenger findPassengerById(Integer id);

    List<Passenger> findPassengersByGender(String gender);

}
