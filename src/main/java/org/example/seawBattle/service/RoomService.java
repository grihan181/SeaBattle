package org.example.seawBattle.service;

import org.example.seawBattle.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
     Room addRoom(Room room);

     void deleteRoomById(Long id);

     List<Room> getAll();

     Room getRoomsByRoomNumber(String roomNum);

}
