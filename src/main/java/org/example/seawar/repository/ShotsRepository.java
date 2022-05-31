package org.example.seawar.repository;

import org.example.seawar.model.Ships;
import org.example.seawar.model.Shots;
import org.example.seawar.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShotsRepository extends JpaRepository<Shots, Long> {
    List<Shots> findByUser(Users user);
}
