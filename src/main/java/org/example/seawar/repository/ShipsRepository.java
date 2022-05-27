package org.example.seawar.repository;

import org.example.seawar.model.Ships;
import org.example.seawar.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipsRepository extends JpaRepository<Ships, Long> {
    List<Ships> findByUser(Users user);
}
