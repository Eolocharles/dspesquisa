package com.eolo.dspesquisa.resources;

import com.eolo.dspesquisa.dto.RecordDTO;
import com.eolo.dspesquisa.dto.RecordInsertDTO;
import com.eolo.dspesquisa.services.RecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.Instant;


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

    @GetMapping
    public ResponseEntity<Page<RecordDTO>> findAll(
            @RequestParam(value = "min", defaultValue = "") String min,
            @RequestParam(value = "max", defaultValue = "") String max,
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "0") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "moment") String orderBy,
            @RequestParam(value = "direction", defaultValue = "DESC") String direction,
            Pageable pageable) {

        Instant minDate = ("".equals(min)) ? null : Instant.parse(min);
        Instant maxDate = ("".equals(max)) ? null : Instant.parse(max);

        if (linesPerPage == 0) {
            linesPerPage = Integer.MAX_VALUE;
        }

        Page<RecordDTO> list = service.findByMoments(minDate, maxDate, pageable);
        return ResponseEntity.ok().body(list);
    }
}
