package com.eolo.dspesquisa.resources;

import com.eolo.dspesquisa.dto.GameDTO;
import com.eolo.dspesquisa.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameResource {

    private final GameService service;

    public GameResource(GameService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<GameDTO>> findAll() {
        List<GameDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
