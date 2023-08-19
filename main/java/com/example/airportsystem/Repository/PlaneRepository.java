package com.example.airportsystem.Repository;

import com.example.airportsystem.Models.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer> {

    Plane findPlaneByNumber(Integer number);

    List<Plane> findPlaneByType(String type);


}
