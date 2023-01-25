package com.eolo.dspesquisa.services;

import com.eolo.dspesquisa.dto.RecordDTO;
import com.eolo.dspesquisa.dto.RecordInsertDTO;
import com.eolo.dspesquisa.entities.Game;
import com.eolo.dspesquisa.entities.Record;
import com.eolo.dspesquisa.repositories.GameRepository;
import com.eolo.dspesquisa.repositories.RecordRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class RecordService {

    public final RecordRepository repository;

    public final GameRepository gameRepository;

    public RecordService(RecordRepository repository, GameRepository gameRepository) {
        this.repository = repository;
        this.gameRepository = gameRepository;
    }

    @Transactional
    public RecordDTO insert(RecordInsertDTO dto) {
        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());

        Game game = gameRepository.getReferenceById(dto.getGameId());
        entity.setGame(game);

        entity = repository.save(entity);
        return new RecordDTO(entity);

    }
}
