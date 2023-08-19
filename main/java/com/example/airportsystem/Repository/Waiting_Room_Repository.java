package com.example.airportsystem.Repository;

import com.example.airportsystem.Models.Waiting_Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Waiting_Room_Repository extends JpaRepository<Waiting_Room, Integer> {

    Waiting_Room findByNumber(Integer numer);

    @Query("select w from Waiting_Room  w where w.seat >= 100")
    List<Waiting_Room> findmore100();



    List<Waiting_Room> findWaiting_RoomsByType(String type);
}
