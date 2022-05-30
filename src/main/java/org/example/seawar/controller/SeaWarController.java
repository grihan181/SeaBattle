package org.example.seawar.controller;


import org.example.seawar.AssistClasses.RoomUsers;
import org.example.seawar.model.Rooms;
import org.example.seawar.model.Ships;
import org.example.seawar.model.Users;
import org.example.seawar.service.RoomService;
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

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @PostMapping ("{roomNumber}/{username}/{shipArray}")
    public void saveShips( @PathVariable String roomNumber,
                           @PathVariable String username,
                           @PathVariable String[] shipArray, Model model) {
        List<Rooms> rooms = roomService.getRoomsByRoomNumber(roomNumber);
        Rooms room = rooms.get(0);
        Users ourUser = new Users();
        List<Users> users = userService.getUsersByRoomsId(room);

        for(String i_j : shipArray) {
            String[] splitI_J = i_j.split("_");
            int i = Integer.parseInt(splitI_J[0]);
            int j = Integer.parseInt(splitI_J[1]);


            for (Users user : users) {
                if (username.equals(user.getUsername())) {
                    ourUser = user;
                }
            }
            Ships ship = new Ships(i, j, ourUser);
            shipService.addShip(ship);
        }
        model.addAttribute("roomNumber", roomNumber);
        model.addAttribute("username", username);

    }
    @GetMapping("{roomNumber}/{username}/userField")
    public List<Ships> takeShips(@PathVariable String roomNumber,
                                 @PathVariable String username,
                                 Model model) {
        List<Rooms> rooms = roomService.getRoomsByRoomNumber(roomNumber);
        Rooms room = rooms.get(0);
        Users ourUser = new Users();
        List<Users> users = userService.getUsersByRoomsId(room);
        for(Users user : users) {
            if(username.equals(user.getUsername())) {
                ourUser = user;
            }
        }
           return shipService.getShipsByUser(ourUser);
    }
}
