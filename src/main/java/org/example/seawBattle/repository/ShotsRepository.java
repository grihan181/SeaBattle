package org.example.seawBattle.repository;

import org.example.seawBattle.model.Shots;
import org.example.seawBattle.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShotsRepository extends JpaRepository<Shots, Long> {
    List<Shots> findByUser(Users user);
}
