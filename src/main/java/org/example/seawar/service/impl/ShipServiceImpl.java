package org.example.seawar.service.impl;

import org.example.seawar.model.Ships;
import org.example.seawar.model.Users;
import org.example.seawar.repository.RoomsRepository;
import org.example.seawar.repository.ShipsRepository;
import org.example.seawar.service.ShipService;
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
