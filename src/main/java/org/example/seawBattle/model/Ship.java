package org.example.seawBattle.model;

import javax.persistence.*;

@Entity
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private int x;
    @Column(nullable = false)
    private int y;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private Users user;

    public Ship() {

    }

    public Ship(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Ship(int x, int y, Users users) {
        this.x = x;
        this.y = y;
        this.user = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users users) {
        this.user = users;
    }
}

