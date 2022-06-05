package org.example.seawBattle.service.impl;

import org.example.seawBattle.service.ShotService;
import org.example.seawBattle.model.Shots;
import org.example.seawBattle.model.Users;
import org.example.seawBattle.repository.ShotsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShotServiceImpl implements ShotService {
    @Autowired
    private ShotsRepository shotsRep;

    @Override
    public Shots addShot(Shots shot) {
        return shotsRep.save(shot);
    }

    @Override
    public List<Shots> getShotsByUser(Users user) {
        return shotsRep.findByUser(user);
    }
}
