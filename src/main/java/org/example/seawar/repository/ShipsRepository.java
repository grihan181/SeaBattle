package org.example.seawar.repository;

import org.example.seawar.model.Ships;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipsRepository extends JpaRepository<Ships, Long> {
}
