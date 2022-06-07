package org.example.seawBattle.repository;

import org.example.seawBattle.model.Ship;
import org.example.seawBattle.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipRepository extends JpaRepository<Ship, Long> {
    List<Ship> findByUser(Users users);
}
