package org.example.seawBattle.service;

import org.example.seawBattle.model.Ship;
import org.example.seawBattle.model.Shot;
import org.example.seawBattle.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShotService {
    Shot addShot(Shot shot);

    List<Shot> getShotsByUser(Users users);

    public void deleteShots(List<Shot> shot);
}
