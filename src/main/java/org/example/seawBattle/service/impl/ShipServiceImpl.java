package org.example.seawBattle.service.impl;

import org.example.seawBattle.model.Ship;
import org.example.seawBattle.model.Users;
import org.example.seawBattle.repository.ShipRepository;
import org.example.seawBattle.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipServiceImpl implements ShipService {
    @Autowired
    private ShipRepository shipRep;

    @Override
    public Ship addShip(Ship ship) {
        return shipRep.save(ship);
    }

    @Override
    public List<Ship> getShipsByUser(Users users) {
        return shipRep.findByUser(users);
    }

    @Override
    public void deleteShips(List<Ship> ships) {
        ships.forEach(ship -> shipRep.delete(ship));
    }
}
