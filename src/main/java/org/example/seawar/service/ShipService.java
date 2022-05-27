package org.example.seawar.service;

import org.example.seawar.model.Ships;
import org.example.seawar.model.Users;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ShipService {
    Ships addShip(Ships ship);

    List<Ships> getShipsByUser(Users user);
}
