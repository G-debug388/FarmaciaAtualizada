package com.curso.services;

import com.curso.domains.Medicamento;
import com.curso.domains.dtos.MedicamentoDTO;
import com.curso.repositories.MedicamentoRepository;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepo;

    public List<MedicamentoDTO> findAll(){
        return medicamentoRepo.findAll().stream().map(obj -> new MedicamentoDTO(obj)).collect(Collectors.toList());
    }

    public Medicamento findById(Long id){
        Optional<Medicamento> obj = medicamentoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Medicamento não encontrado! ID: "+id));
    }

    public Medicamento findByNome(String nome){
        Optional<Medicamento> obj = medicamentoRepo.findByNome(nome);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Medicamento não encontrado! Nome: "+nome));
    }

    public Medicamento findByPrinAtivo(String prinAtivo){
        Optional<Medicamento> obj = medicamentoRepo.findByPrinAtivo(prinAtivo);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Medicamento não encontrado! Princípio ativo: "+prinAtivo));
    }

    public Medicamento create(MedicamentoDTO dto){
        dto.setId(null);
        Medicamento obj = new Medicamento(dto);
        return medicamentoRepo.save(obj);
    }

    public Medicamento update(Long id, MedicamentoDTO objDto){
        objDto.setId(id);
        Medicamento oldObj = findById(id);
        oldObj = new Medicamento(objDto);
        return medicamentoRepo.save(oldObj);
    }

    public void delete(Long id){
        Medicamento obj = findById(id);
        medicamentoRepo.deleteById(id);
    }
}
