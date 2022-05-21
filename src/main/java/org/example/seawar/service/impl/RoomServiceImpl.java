package org.example.seawar.service.impl;

import org.example.seawar.model.Rooms;
import org.example.seawar.repository.RoomsRepository;
import org.example.seawar.service.RoomService;
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
