package org.example.seawBattle.repository;

import org.example.seawBattle.model.Room;
import org.example.seawBattle.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findByUsernameAndRoom(String username, Room room);
    List<Users> findByUsernameNotAndRoom(String username, Room room);

}
