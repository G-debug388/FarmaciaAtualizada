package com.curso.resources;

import com.curso.domains.Medicamento;
import com.curso.domains.dtos.MedicamentoDTO;
import com.curso.services.MedicamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/medicamento")
public class MedicamentoResource {

    @Autowired
    private MedicamentoService medicamentoService;

    @GetMapping
    public ResponseEntity<List<MedicamentoDTO>> findAll(){
        return ResponseEntity.ok().body(medicamentoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicamentoDTO> findById(@PathVariable Long id) {
        Medicamento obj = this.medicamentoService.findById(id);
        return ResponseEntity.ok().body(new MedicamentoDTO(obj));
    }

    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<MedicamentoDTO> findById(@PathVariable String nome) {
        Medicamento obj = this.medicamentoService.findByNome(nome);
        return ResponseEntity.ok().body(new MedicamentoDTO(obj));
    }

    @GetMapping(value = "/prinAtivo/{prinAtivo}")
    public ResponseEntity<MedicamentoDTO> findByNome(@PathVariable String prinAtivo) {
        Medicamento obj = this.medicamentoService.findByPrinAtivo(prinAtivo);
        return ResponseEntity.ok().body(new MedicamentoDTO(obj));
    }

    @PostMapping
    public ResponseEntity<MedicamentoDTO> create(@Valid @RequestBody MedicamentoDTO dto){
        Medicamento medicamento = medicamentoService.create(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(medicamento.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MedicamentoDTO> update(@PathVariable Long id, @Valid @RequestBody MedicamentoDTO objDto){
        Medicamento Obj = medicamentoService.update(id, objDto);
        return ResponseEntity.ok().body(new MedicamentoDTO(Obj));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<MedicamentoDTO> delete(@PathVariable Long id){
        medicamentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
