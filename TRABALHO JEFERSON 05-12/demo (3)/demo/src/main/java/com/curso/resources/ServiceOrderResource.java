package com.curso.resources;

import com.curso.domains.ServiceOrder;
import com.curso.dtos.ServiceOrderDTO;
import com.curso.services.ServiceOrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service-orders")
public class ServiceOrderResource {

    @Autowired
    private ServiceOrderService service;

    @GetMapping
    public ResponseEntity<List<ServiceOrderDTO>> findAll() {
        List<ServiceOrderDTO> list = service.findAll().stream().map(ServiceOrderDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderDTO> findById(@PathVariable UUID id) {
        ServiceOrder obj = service.findById(id);
        return ResponseEntity.ok().body(new ServiceOrderDTO(obj));
    }

    @PostMapping
    public ResponseEntity<ServiceOrderDTO> create(@Valid @RequestBody ServiceOrderDTO dto) {
        ServiceOrder obj = service.create(dto);
        return ResponseEntity.created(URI.create("/service-orders/" + obj.getId())).body(new ServiceOrderDTO(obj));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServiceOrderDTO> update(@PathVariable UUID id, @Valid @RequestBody ServiceOrderDTO dto) {
        ServiceOrder obj = service.update(id, dto);
        return ResponseEntity.ok().body(new ServiceOrderDTO(obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
