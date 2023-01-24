package com.eolo.dspesquisa.repositories;

import com.eolo.dspesquisa.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    @Query("SELECT obj FROM Game obj JOIN FETCH obj.genre ORDER BY obj.title")
    List<Game> findAll();
}

