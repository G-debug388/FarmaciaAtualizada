package com.curso.resources;

import com.curso.domains.Technician;
import com.curso.dtos.TechnicianDTO;
import com.curso.services.TechnicianService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/technicians")
public class TechnicianResource {

    @Autowired
    private TechnicianService service;

    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll() {
        List<TechnicianDTO> list = service.findAll().stream().map(TechnicianDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id) {
        Technician obj = service.findById(id);
        return ResponseEntity.ok().body(new TechnicianDTO(obj));
    }

    @PostMapping
    public ResponseEntity<TechnicianDTO> create(@Valid @RequestBody TechnicianDTO dto) {
        Technician obj = service.create(dto);
        return ResponseEntity.created(URI.create("/technicians/" + obj.getId())).body(new TechnicianDTO(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TechnicianDTO> update(@PathVariable Integer id, @Valid @RequestBody TechnicianDTO dto) {
        Technician obj = service.update(id, dto);
        return ResponseEntity.ok().body(new TechnicianDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
