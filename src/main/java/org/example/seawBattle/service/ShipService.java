package org.example.seawBattle.service;

import org.example.seawBattle.model.Ships;
import org.example.seawBattle.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipService {
    Ships addShip(Ships ship);

    List<Ships> getShipsByUser(Users user);
}
