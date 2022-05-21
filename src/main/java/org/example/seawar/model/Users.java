package org.example.seawar.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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
    private Set<Shots> shots = new HashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<Ships> ships = new HashSet<>();

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

    public Rooms getRoomId() {
        return room;
    }

    public void setRoomId(Rooms roomId) {
        this.room = roomId;
    }

    public Rooms getRoom() {
        return room;
    }

    public void setRoom(Rooms room) {
        this.room = room;
    }

    public Set<Shots> getShots() {
        return shots;
    }

    public void setShots(Set<Shots> shots) {
        this.shots = shots;
    }

    public Set<Ships> getShips() {
        return ships;
    }

    public void setShips(Set<Ships> ships) {
        this.ships = ships;
    }
}
