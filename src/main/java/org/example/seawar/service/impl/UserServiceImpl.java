package org.example.seawar.service.impl;

import org.example.seawar.model.Rooms;
import org.example.seawar.model.Users;
import org.example.seawar.repository.UsersRepository;
import org.example.seawar.service.UserService;
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
