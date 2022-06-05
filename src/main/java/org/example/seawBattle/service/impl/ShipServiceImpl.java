package org.example.seawBattle.service.impl;

import org.example.seawBattle.model.Ships;
import org.example.seawBattle.model.Users;
import org.example.seawBattle.repository.ShipsRepository;
import org.example.seawBattle.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    private ShipsRepository shipsRep;

    @Override
    public Ships addShip(Ships ship) {
        return shipsRep.save(ship);
    }

    @Override
    public List<Ships> getShipsByUser(Users user) {
        return shipsRep.findByUser(user);
    }
}
