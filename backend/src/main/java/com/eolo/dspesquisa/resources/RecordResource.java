package com.eolo.dspesquisa.resources;

import com.eolo.dspesquisa.dto.RecordDTO;
import com.eolo.dspesquisa.dto.RecordInsertDTO;
import com.eolo.dspesquisa.services.RecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/records")
public class RecordResource {

    public final RecordService service;

    public RecordResource(RecordService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RecordDTO> insert(@RequestBody RecordInsertDTO dto) {
        RecordDTO newDTO = service.insert(dto);
        return ResponseEntity.ok().body(newDTO);
    }
}
