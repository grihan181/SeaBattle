package org.example.seawBattle.service.impl;

import org.example.seawBattle.model.Users;
import org.example.seawBattle.service.UserService;
import org.example.seawBattle.model.Room;
import org.example.seawBattle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRep;

    @Override
    public Users addUser(Users users) {
        return userRep.save(users);
    }

    @Override
    public void deleteUserById(Long id) {
        userRep.deleteById(id);
    }

    @Override
    public List<Users> getAll() {
        return userRep.findAll();
    }

    @Override
    public Users getOurUser(String useranme, Room room) {
        return userRep.findByUsernameAndRoom(useranme, room).get(0);
    }

    @Override
    public Users getOtherUser(String useranme, Room room) {
        return userRep.findByUsernameNotAndRoom(useranme, room).get(0);
    }
}
