package org.example.seawar.repository;

import org.example.seawar.model.Rooms;
import org.example.seawar.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    List<Users> findByRoom(Rooms room);
}
