package org.example.seawBattle.service.impl;

import org.example.seawBattle.model.Room;
import org.example.seawBattle.repository.RoomRepository;
import org.example.seawBattle.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRep;

    @Override
    public Room addRoom(Room room) {
        return roomRep.save(room);
    }

    @Override
    public void deleteRoomById(Long id) {
        roomRep.deleteById(id);
    }

    @Override
    public List<Room> getAll() {
        return roomRep.findAll();
    }

    @Override
    public Room getRoomsByRoomNumber(String roomNumber) {
        List<Room> rooms = roomRep.findByRoomNumber(roomNumber);
        if(rooms.size() > 0) {
            return rooms.get(0);
        } else {
            return null;
        }

    }
}
