package org.example.seawar.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "rooms_id")
    private Rooms room;

    @OneToMany(mappedBy = "user")
    private List<Shots> shots = new LinkedList<>();

    @OneToMany(mappedBy = "user")
    private List<Ships> ships = new LinkedList<>();

    public Users() {
    }
    public Users(String username, String password, Rooms room) {
        this.username = username;
        this.password = password;
        this.room = room;

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public List<Shots> getShots() {
        return shots;
    }

    public void setShots(List<Shots> shots) {
        this.shots = shots;
    }

    public List<Ships> getShips() {
        return ships;
    }

    public void setShips(List<Ships> ships) {
        this.ships = ships;
    }
}
