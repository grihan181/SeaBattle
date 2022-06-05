package org.example.seawBattle.service.impl;

import org.example.seawBattle.service.UserService;
import org.example.seawBattle.model.Rooms;
import org.example.seawBattle.model.Users;
import org.example.seawBattle.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRep;

    @Override
    public Users addUser(Users user) {
        return usersRep.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        usersRep.deleteById(id);
    }

    @Override
    public List<Users> getAll() {
        return usersRep.findAll();
    }

    @Override
    public List<Users> getUsersByRoomsId(Rooms room) {
        return usersRep.findByRoom(room);
    }
}
