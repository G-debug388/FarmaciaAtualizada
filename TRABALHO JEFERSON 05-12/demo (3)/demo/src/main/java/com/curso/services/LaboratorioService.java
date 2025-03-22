package com.curso.services;

import com.curso.domains.Fornecedor;
import com.curso.domains.Laboratorio;
import com.curso.domains.dtos.LaboratorioDTO;
import com.curso.repositories.LaboratorioRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LaboratorioService {

    @Autowired
    private LaboratorioRepository laboratorioRepo;

    public List<LaboratorioDTO> findAll(){
        return laboratorioRepo.findAll().stream().map(obj -> new LaboratorioDTO(obj)).collect(Collectors.toList());
    }

    public Laboratorio findById(int id){
        Optional<Laboratorio> obj = laboratorioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Laboratório não encontrado! ID: "+id));
    }

    public Laboratorio findByCnpj(String cnpj){
        Optional<Laboratorio> obj = laboratorioRepo.findByCnpj(cnpj);
        return obj.orElse(null);
    }

    public Laboratorio create(LaboratorioDTO dto){
        dto.setId(null);
        Laboratorio obj = new Laboratorio(dto);
        return laboratorioRepo.save(obj);
    }

    public Laboratorio update(Integer id, LaboratorioDTO objDto){
        objDto.setId(id);
        Laboratorio oldObj = findById(id);
        oldObj = new Laboratorio(objDto);
        return laboratorioRepo.save(oldObj);
    }

    public void delete(Integer id){
        Laboratorio obj = findById(id);
        if(obj.getMedicamentos().size()>0){
            throw new DataIntegrityViolationException("Laboratório não pode ser deletado pois possui Medicamentos vinculados!");
        }
        laboratorioRepo.deleteById(id);
    }
}
