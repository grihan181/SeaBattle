package org.example.seawBattle.service;

import org.example.seawBattle.model.Room;
import org.example.seawBattle.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
     Users addUser(Users users);

     void deleteUserById(Long id);

     List<Users> getAll();

    Users getOurUser(String useranme, Room room);

    Users getOtherUser(String useranme, Room room);
}
