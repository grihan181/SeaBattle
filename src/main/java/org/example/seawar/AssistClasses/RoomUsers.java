package org.example.seawar.AssistClasses;

import org.example.seawar.model.Rooms;
import org.example.seawar.model.Users;

public class RoomUsers {
    private Rooms room;
    private Users user1;
    private Users user2;

    public RoomUsers() {

    }
    public RoomUsers(Rooms room, Users user1, Users user2) {
        this.room = room;
        this.user1 = user1;
        this.user2 = user2;
    }
    public RoomUsers(Rooms room, Users user1) {
        this.room = room;
        this.user1 = user1;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Users getUser1() {
        return user1;
    }

    public void setUser1(Users user1) {
        this.user1 = user1;
    }

    public Users getUser2() {
        return user2;
    }

    public void setUser2(Users user2) {
        this.user2 = user2;
    }

    @Override
    public String toString() {
        return "RoomUsers{" +
                "room=" + room +
                ", user1=" + user1 +
                ", user2=" + user2 +
                '}';
    }
}

