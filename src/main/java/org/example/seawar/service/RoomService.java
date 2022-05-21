package org.example.seawar.service;

import org.example.seawar.model.Rooms;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {
     Rooms addRoom(Rooms room);

     void deleteRoomById(Long id);

     List<Rooms> getAll();

     List<Rooms> getRoomsByRoomNumber(String roomNum);

}
