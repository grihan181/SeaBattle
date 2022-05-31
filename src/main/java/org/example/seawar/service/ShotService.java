package org.example.seawar.service;

import org.example.seawar.model.Shots;
import org.example.seawar.model.Users;

import java.util.List;

public interface ShotService {
    Shots addShot(Shots shot);

    List<Shots> getShotsByUser(Users user);
}
