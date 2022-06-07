package org.example.seawBattle.service.impl;

import org.example.seawBattle.model.Ship;
import org.example.seawBattle.service.ShotService;
import org.example.seawBattle.model.Shot;
import org.example.seawBattle.model.Users;
import org.example.seawBattle.repository.ShotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShotServiceImpl implements ShotService {
    @Autowired
    private ShotRepository shotRep;

    @Override
    public Shot addShot(Shot shot) {
        return shotRep.save(shot);
    }

    @Override
    public List<Shot> getShotsByUser(Users users) {
        return shotRep.findByUser(users);
    }

    @Override
    public void deleteShots(List<Shot> shots) {
        shots.forEach(shot -> shotRep.delete(shot));
    }
}
