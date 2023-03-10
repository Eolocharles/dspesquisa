package com.eolo.dspesquisa.services;

import com.eolo.dspesquisa.dto.GameDTO;
import com.eolo.dspesquisa.entities.Game;
import com.eolo.dspesquisa.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameDTO> findAll() {
        List<Game> list = gameRepository.findAll();
        return list.stream().map(GameDTO::new).collect(Collectors.toList());
    }
}
