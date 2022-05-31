package org.example.seawar.service.impl;

import org.example.seawar.model.Ships;
import org.example.seawar.model.Shots;
import org.example.seawar.model.Users;
import org.example.seawar.repository.ShotsRepository;
import org.example.seawar.service.ShotService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
