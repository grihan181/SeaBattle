package org.example.seawBattle.repository;

import org.example.seawBattle.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Long> {
    List<Rooms> findByRoomNumber(String roomNumber);
}
