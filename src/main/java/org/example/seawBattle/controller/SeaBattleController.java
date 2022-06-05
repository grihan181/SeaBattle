package org.example.seawBattle.controller;


import org.example.seawBattle.AssistClasses.ShipShotCoordinates;
import org.example.seawBattle.model.Rooms;
import org.example.seawBattle.model.Ships;
import org.example.seawBattle.model.Shots;
import org.example.seawBattle.model.Users;
import org.example.seawBattle.service.RoomService;
import org.example.seawBattle.service.ShipService;
import org.example.seawBattle.service.ShotService;
import org.example.seawBattle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/seaBattle")
public class SeaBattleController {

    @Autowired
    private ShipService shipService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private ShotService shotService;

    @PostMapping ("{roomNumber}/{username}/{shipArray}/ships")
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
    @PostMapping("{roomNumber}/{username}/{i_j}/shot")
    public void addShots(@PathVariable String roomNumber,
                          @PathVariable String username,
                          @PathVariable String i_j) {
        Users ourUser = takeOurUser(roomNumber, username);

        String[] splitI_J = i_j.split("_");
        int i = Integer.parseInt(splitI_J[0]);
        int j = Integer.parseInt(splitI_J[1]);

        shotService.addShot(new Shots(i, j, ourUser));
    }
    @GetMapping("{roomNumber}/{username}/{i_j}/checkShot")
    public boolean checkShot(@PathVariable String roomNumber,
                           @PathVariable String username,
                           @PathVariable String i_j) {
        Users enemy = takeOtherUsers(roomNumber, username);
        String[] splitI_J = i_j.split("_");
        int i = Integer.parseInt(splitI_J[0]);
        int j = Integer.parseInt(splitI_J[1]);

        List<Ships> enemyShips = shipService.getShipsByUser(enemy);
        for(Ships ship : enemyShips) {
            if(ship.getX() == i && ship.getY() == j) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("{roomNumber}/{username}/userFieldShips")
    public List<ShipShotCoordinates> takeUserShips(@PathVariable String roomNumber,
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
    @GetMapping("{roomNumber}/{username}/userFieldShots")
    public List<ShipShotCoordinates> takeUserShots(@PathVariable String roomNumber,
                                               @PathVariable String username,  Model model) {
        Users ourUser = takeOurUser(roomNumber, username);
        return takeShots(ourUser);
    }
    @GetMapping("{roomNumber}/{username}/enemyFieldShots")
    public List<ShipShotCoordinates> takeEnemyShots(@PathVariable String roomNumber,
                                               @PathVariable String username,  Model model) {
        Users otherUser = takeOtherUsers(roomNumber, username);
        return takeShots(otherUser);
    }

    public List<ShipShotCoordinates> takeShots(Users user) {

        List<ShipShotCoordinates> coord = new LinkedList<>();
        List<Shots> shots = shotService.getShotsByUser(user);
        if(shots.size() == 0) {
            coord.add(new ShipShotCoordinates(0, 0));
            return coord;
        }


        for(Shots shot : shots) {
            coord.add(new ShipShotCoordinates(shot.getX(), shot.getY()));
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
    public Users takeOtherUsers(String roomNumber,String username) {
        List<Rooms> rooms = roomService.getRoomsByRoomNumber(roomNumber);
        Rooms room = rooms.get(0);
        Users otherUser = new Users();
        List<Users> users = userService.getUsersByRoomsId(room);

        for (Users user : users) {
            if (!username.equals(user.getUsername())) {
                otherUser = user;
            }
        }
        return otherUser;
    }
}
