package org.example.seawBattle.controller;


import org.example.seawBattle.AssistClasses.ShipShotCoordinates;
import org.example.seawBattle.model.Room;
import org.example.seawBattle.model.Ship;
import org.example.seawBattle.model.Shot;
import org.example.seawBattle.model.Users;
import org.example.seawBattle.service.RoomService;
import org.example.seawBattle.service.ShipService;
import org.example.seawBattle.service.ShotService;
import org.example.seawBattle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

        Users ourUsers = userService.getOurUser(username, roomService.getRoomsByRoomNumber(roomNumber));

        for(String i_j : shipArray) {
            String[] splitI_J = i_j.split("_");
            int i = Integer.parseInt(splitI_J[0]);
            int j = Integer.parseInt(splitI_J[1]);

            Ship ship = new Ship(i, j, ourUsers);
            shipService.addShip(ship);
        }
        return true;
    }
    @PostMapping("{roomNumber}/{username}/{i_j}/shot")
    public void addShots(@PathVariable String roomNumber,
                          @PathVariable String username,
                          @PathVariable String i_j) {
        Users ourUsers = userService.getOurUser(username, roomService.getRoomsByRoomNumber(roomNumber));

        String[] splitI_J = i_j.split("_");
        int i = Integer.parseInt(splitI_J[0]);
        int j = Integer.parseInt(splitI_J[1]);

        shotService.addShot(new Shot(i, j, ourUsers));
    }
    @GetMapping("{roomNumber}/{username}/{i_j}/checkShot")
    public boolean checkShot(@PathVariable String roomNumber,
                           @PathVariable String username,
                           @PathVariable String i_j) {
        Users enemy = userService.getOtherUser(username, roomService.getRoomsByRoomNumber(roomNumber));

        String[] splitI_J = i_j.split("_");
        int i = Integer.parseInt(splitI_J[0]);
        int j = Integer.parseInt(splitI_J[1]);

        List<Ship> enemyShips = shipService.getShipsByUser(enemy);
        for(Ship ship : enemyShips) {
            if(ship.getX() == i && ship.getY() == j) {
                return true;
            }
        }
        return false;
    }

    @GetMapping("{roomNumber}/{username}/userFieldShips")
    public List<ShipShotCoordinates> takeUserShips(@PathVariable String roomNumber,
                                 @PathVariable String username) {
        Users ourUsers = userService.getOurUser(username, roomService.getRoomsByRoomNumber(roomNumber));

        List<ShipShotCoordinates> coord = new LinkedList<>();
        List<Ship> ships = shipService.getShipsByUser(ourUsers);
        if(ships.size() == 0) {
            coord.add(new ShipShotCoordinates(0, 0));
            return coord;
        }


        for(Ship ship : ships) {
            coord.add(new ShipShotCoordinates(ship.getX(), ship.getY()));
        }
        return coord;
    }
    @GetMapping("{roomNumber}/{username}/userFieldShots")
    public List<ShipShotCoordinates> takeUserShots(@PathVariable String roomNumber,
                                               @PathVariable String username) {
        return takeShots(userService.getOurUser(username, roomService.getRoomsByRoomNumber(roomNumber)));
    }
    @GetMapping("{roomNumber}/{username}/enemyFieldShots")
    public List<ShipShotCoordinates> takeEnemyShots(@PathVariable String roomNumber,
                                               @PathVariable String username) {
        return takeShots(userService.getOtherUser(username, roomService.getRoomsByRoomNumber(roomNumber)));
    }

    @DeleteMapping("{roomNumber}/{username}")
    public void deleteShotsAndShips(@PathVariable String roomNumber,
                                    @PathVariable String username) {
        Users ourUser = userService.getOurUser(username, roomService.getRoomsByRoomNumber(roomNumber));
        List<Ship> ships = shipService.getShipsByUser(ourUser);
        List<Shot> shots = shotService.getShotsByUser(ourUser);
        shipService.deleteShips(ships);
        shotService.deleteShots(shots);

        Users otherUser = userService.getOtherUser(username, roomService.getRoomsByRoomNumber(roomNumber));
        ships = shipService.getShipsByUser(otherUser);
        shots = shotService.getShotsByUser(otherUser);
        shipService.deleteShips(ships);
        shotService.deleteShots(shots);
    }

    public List<ShipShotCoordinates> takeShots(Users user) {

        List<ShipShotCoordinates> coord = new LinkedList<>();
        List<Shot> shots = shotService.getShotsByUser(user);
        if(shots.size() == 0) {
            coord.add(new ShipShotCoordinates(0, 0));
            return coord;
        }


        for(Shot shot : shots) {
            coord.add(new ShipShotCoordinates(shot.getX(), shot.getY()));
        }
        return coord;
    }
}
