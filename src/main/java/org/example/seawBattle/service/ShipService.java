package org.example.seawBattle.service;

import org.example.seawBattle.model.Ship;
import org.example.seawBattle.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipService {
    Ship addShip(Ship ship);

    List<Ship> getShipsByUser(Users users);

    public void deleteShips(List<Ship> ships);
}
