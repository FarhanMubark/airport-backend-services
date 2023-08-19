package com.example.airportsystem.Services;

import com.example.airportsystem.Api.ApiException;
import com.example.airportsystem.Models.Waiting_Room;
import com.example.airportsystem.Repository.Waiting_Room_Repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class Waiting_Room_Service {

    final private Waiting_Room_Repository waitingRoomRepository;

    public List<Waiting_Room> getall(){
        return waitingRoomRepository.findAll();
    }

    public void addWaitingRoom(Waiting_Room waitingRoom){
        waitingRoomRepository.save(waitingRoom);
    }

    public void updateRoom(Integer number, Waiting_Room waitingRoom){
        Waiting_Room oldRoom = waitingRoomRepository.findByNumber(number);

        if (number ==null){
            throw new ApiException("Number Not found");

        }
        oldRoom.setNumber(waitingRoom.getNumber());
        oldRoom.setSeat(waitingRoom.getSeat());
        oldRoom.setType(waitingRoom.getType());
        waitingRoomRepository.save(oldRoom);
    }

    public void deleteRoom(Integer number){
        Waiting_Room room = waitingRoomRepository.findByNumber(number);

        if (room ==null){
            throw new ApiException("Number Not found");

        }

        waitingRoomRepository.delete(room);

    }

    public List<Waiting_Room> getallByType(String type){
        List<Waiting_Room> rooms = waitingRoomRepository.findWaiting_RoomsByType(type);
        if (rooms ==null){
            throw new ApiException("Type Not found");
        }

        return rooms;
    }


    public List<Waiting_Room> findmore100seat(){
        return waitingRoomRepository.findmore100();
    }
}
