package com.curso.services;

import com.curso.domains.Technician;
import com.curso.dtos.TechnicianDTO;
import com.curso.repositories.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository repository;

    public Technician findById(Integer id) {
        Optional<Technician> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Técnico não encontrado com ID: " + id));
    }

    public List<Technician> findAll() {
        return repository.findAll();
    }

    public Technician create(TechnicianDTO dto) {
        Technician obj = new Technician(null, dto.getName(), dto.getCpf(), dto.getEmail(), dto.getPassword());
        return repository.save(obj);
    }

    public Technician update(Integer id, TechnicianDTO dto) {
        Technician obj = findById(id);
        obj.setName(dto.getName());
        obj.setCpf(dto.getCpf());
        obj.setEmail(dto.getEmail());
        obj.setPassword(dto.getPassword());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        Technician obj = findById(id);
        repository.delete(obj);
    }
}
