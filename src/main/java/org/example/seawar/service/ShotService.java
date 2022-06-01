package org.example.seawar.service;

import org.example.seawar.model.Shots;
import org.example.seawar.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShotService {
    Shots addShot(Shots shot);

    List<Shots> getShotsByUser(Users user);
}
