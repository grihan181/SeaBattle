package org.example.seawar.controller;


import org.example.seawar.AssistClasses.RoomUsers;
import org.example.seawar.model.Rooms;
import org.example.seawar.model.Ships;
import org.example.seawar.model.Users;
import org.example.seawar.service.ShipService;
import org.example.seawar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seaWar")
public class SeaWarController {

    @Autowired
    private ShipService shipService;


    @PostMapping ("{i_j}")
    public Ships saveShips(@PathVariable String i_j, Model model) {
       String[] splitI_J = i_j.split("_");
       int i = Integer.parseInt(splitI_J[0]);
       int j = Integer.parseInt(splitI_J[1]);

       Ships ship = new Ships(i, j);
       return shipService.addShip(ship);
    }
    @GetMapping("{roomNumber}/{username}")
    public List<Ships> takeShips(@PathVariable String username,
                                 Model model) {
       RoomUsers roomUsers = (RoomUsers) model.getAttribute("roomUser");
       if(username.equals("user1")) {
           return shipService.getShipsByUser(roomUsers.getUser1());
       } else {
           return shipService.getShipsByUser(roomUsers.getUser2());
       }


    }
}
