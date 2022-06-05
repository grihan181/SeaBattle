package org.example.seawBattle.service.impl;

import org.example.seawBattle.model.Rooms;
import org.example.seawBattle.repository.RoomsRepository;
import org.example.seawBattle.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomsRepository roomsRep;

    @Override
    public Rooms addRoom(Rooms room) {
        return roomsRep.save(room);
    }

    @Override
    public void deleteRoomById(Long id) {
        roomsRep.deleteById(id);
    }

    @Override
    public List<Rooms> getAll() {
        return roomsRep.findAll();
    }

    @Override
    public List<Rooms> getRoomsByRoomNumber(String roomNumber) {
        return roomsRep.findByRoomNumber(roomNumber);
    }
}
