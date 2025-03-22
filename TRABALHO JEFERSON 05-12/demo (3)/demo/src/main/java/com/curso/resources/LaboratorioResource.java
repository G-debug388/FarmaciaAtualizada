package com.curso.resources;

import com.curso.domains.Laboratorio;
import com.curso.domains.Medicamento;
import com.curso.domains.dtos.LaboratorioDTO;
import com.curso.domains.dtos.MedicamentoDTO;
import com.curso.services.LaboratorioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/laboratorio")
public class LaboratorioResource {
    @Autowired
    private LaboratorioService laboratorioService;

    @GetMapping
    public ResponseEntity<List<LaboratorioDTO>> findAll() {
        return ResponseEntity.ok().body(laboratorioService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LaboratorioDTO> findById(@PathVariable int id) {
        Laboratorio obj = this.laboratorioService.findById(id);
        return ResponseEntity.ok().body(new LaboratorioDTO(obj));
    }
    @GetMapping(value = "/cnpj/{cnpj}")
    public ResponseEntity<LaboratorioDTO> findByNome(@PathVariable String cnpj) {
        Laboratorio obj = this.laboratorioService.findByCnpj(cnpj);
        return ResponseEntity.ok().body(new LaboratorioDTO(obj));
    }
    @PostMapping
    public ResponseEntity<LaboratorioDTO> create(@Valid @RequestBody LaboratorioDTO dto){
        Laboratorio laboratorio = laboratorioService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(laboratorio.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LaboratorioDTO> update(@PathVariable Integer id, @Valid @RequestBody LaboratorioDTO objDto){
        Laboratorio Obj = laboratorioService.update(id,objDto);
        return ResponseEntity.ok().body(new LaboratorioDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LaboratorioDTO> delete(@PathVariable Integer id){
        laboratorioService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
