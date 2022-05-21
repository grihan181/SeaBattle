package org.example.seawar.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long id;

    @Column(name="room_number", nullable = false)
    private String roomNumber;

    @OneToMany(mappedBy = "room")
    private Set<Users> users = new HashSet<>();

    public Rooms() {

    }

    public Rooms(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getId() {
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

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

}
