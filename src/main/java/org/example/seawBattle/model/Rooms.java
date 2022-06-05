package org.example.seawBattle.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(name="room_number", nullable = false)
    private String roomNumber;

    @OneToMany(mappedBy = "room")
    private List<Users> users = new LinkedList<>();

    public Rooms() {

    }

    public Rooms(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
