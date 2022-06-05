package org.example.seawBattle.service;

import org.example.seawBattle.model.Shots;
import org.example.seawBattle.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShotService {
    Shots addShot(Shots shot);

    List<Shots> getShotsByUser(Users user);
}
