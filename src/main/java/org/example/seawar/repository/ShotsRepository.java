package org.example.seawar.repository;

import org.example.seawar.model.Shots;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShotsRepository extends JpaRepository<Shots, Long> {

}
