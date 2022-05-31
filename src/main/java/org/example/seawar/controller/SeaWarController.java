package org.example.seawar.controller;


import org.example.seawar.AssistClasses.RoomUsers;
import org.example.seawar.AssistClasses.ShipShotCoordinates;
import org.example.seawar.model.Rooms;
import org.example.seawar.model.Ships;
import org.example.seawar.model.Shots;
import org.example.seawar.model.Users;
import org.example.seawar.service.RoomService;
import org.example.seawar.service.ShipService;
import org.example.seawar.service.ShotService;
import org.example.seawar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seaWar")
public class SeaWarController {

    @Autowired
    private ShipService shipService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ShotService shotService;

    @PostMapping ("{roomNumber}/{username}/{shipArray}")
    public boolean saveShips(@PathVariable String roomNumber,
                             @PathVariable String username,
                             @PathVariable String[] shipArray) {

        Users ourUser = takeOurUser(roomNumber, username);

        for(String i_j : shipArray) {
            String[] splitI_J = i_j.split("_");
            int i = Integer.parseInt(splitI_J[0]);
            int j = Integer.parseInt(splitI_J[1]);

            Ships ship = new Ships(i, j, ourUser);
            shipService.addShip(ship);
        }
        return true;
    }
    @PostMapping("{roomNumber}/{username}/{i_j}")
    public Shots addShots(@PathVariable String roomNumber,
                          @PathVariable String username,
                          @PathVariable String i_j) {
        Users ourUser = takeOurUser(roomNumber, username);

        String[] splitI_J = i_j.split("_");
        int i = Integer.parseInt(splitI_J[0]);
        int j = Integer.parseInt(splitI_J[1]);

        return shotService.addShot(new Shots(i, j, ourUser));
    }


    @GetMapping("{roomNumber}/{username}/userField")
    public List<ShipShotCoordinates> takeShips(@PathVariable String roomNumber,
                                 @PathVariable String username,  Model model) {
        Users ourUser = takeOurUser(roomNumber, username);

        List<ShipShotCoordinates> coord = new LinkedList<>();
        List<Ships> ships = shipService.getShipsByUser(ourUser);
        if(ships.size() == 0) {
            coord.add(new ShipShotCoordinates(0, 0));
            return coord;
        }


        for(Ships ship : ships) {
            coord.add(new ShipShotCoordinates(ship.getX(), ship.getY()));
        }
        return coord;
    }

    public Users takeOurUser(String roomNumber,String username) {
        List<Rooms> rooms = roomService.getRoomsByRoomNumber(roomNumber);
        Rooms room = rooms.get(0);
        Users ourUser = new Users();
        List<Users> users = userService.getUsersByRoomsId(room);

        for (Users user : users) {
            if (username.equals(user.getUsername())) {
                ourUser = user;
            }
        }
        return ourUser;
    }
}
