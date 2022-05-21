package org.example.seawar.service;

import org.example.seawar.model.Rooms;
import org.example.seawar.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     Users addUser(Users user);

     void deleteUserById(Long id);

     List<Users> getAll();

    List<Users> getUsersByRoomsId(Rooms room);
}
