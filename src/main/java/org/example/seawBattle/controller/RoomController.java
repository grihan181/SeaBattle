package org.example.seawBattle.controller;

import org.example.seawBattle.service.RoomService;
import org.example.seawBattle.service.UserService;
import org.example.seawBattle.AssistClasses.RoomUsers;
import org.example.seawBattle.model.Room;
import org.example.seawBattle.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(path = "api/v1/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private UserService userService;

    @GetMapping("{roomNumber}")
    public boolean checkRoom(@PathVariable String roomNumber, Model model) {
        Room room = roomService.getRoomsByRoomNumber(roomNumber);
        if(room != null) {
            model.addAttribute("roomNumber", room);
            return true;
        }
        return false;
    }
    @GetMapping("{roomNumber}/{username}")
    public boolean checkUser(@PathVariable String roomNumber,
                             @PathVariable String username,
                             @RequestParam String password) {
        Room room = roomService.getRoomsByRoomNumber(roomNumber);
        Users user = userService.getOurUser(username, room);
        return user.getUsername().equals(username) &&
                user.getPassword().equals(password);
    }

    @PostMapping
    public RoomUsers makeRoom() {
        RoomUsers roomUsers;
        Users user1;
        Users user2;
        Room room;

        String roomNumber = "";
        boolean flag = false;

        while (!flag) {
            roomNumber = getRandomNumberString(6);
            if (roomService.getRoomsByRoomNumber(roomNumber) == null) {
                flag = true;
            }
        }
        room = roomService.addRoom(new Room(roomNumber));

        user1 = userService.addUser(new Users("user1", getRandomNumberString(4), room));
        user2 = userService.addUser(new Users("user2", getRandomNumberString(4), room));
        roomUsers = new RoomUsers(room, user1, user2);


        return roomUsers;
    }


    public static String getRandomNumberString(int length) {
        Random rnd = new Random();
        int number;
        if (length == 6) {
            number  = rnd.nextInt(999999);
            return String.format("%06d", number);
        } else if  (length == 4) {
            number  = rnd.nextInt(9999);
            return String.format("%04d", number);
        }
        return "0";
    }
}
