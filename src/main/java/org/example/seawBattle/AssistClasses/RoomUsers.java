package org.example.seawBattle.AssistClasses;

import org.example.seawBattle.model.Room;
import org.example.seawBattle.model.Users;

public class RoomUsers {
    private Room room;
    private Users user1;
    private Users user2;

    public RoomUsers() {

    }
    public RoomUsers(Room room, Users user1, Users user2) {
        this.room = room;
        this.user1 = user1;
        this.user2 = user2;
    }
    public RoomUsers(Room room, Users user1) {
        this.room = room;
        this.user1 = user1;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Users getUser1() {
        return user1;
    }

    public void setUser1(Users users1) {
        this.user1 = users1;
    }

    public Users getUser2() {
        return user2;
    }

    public void setUser2(Users users2) {
        this.user2 = users2;
    }

}

