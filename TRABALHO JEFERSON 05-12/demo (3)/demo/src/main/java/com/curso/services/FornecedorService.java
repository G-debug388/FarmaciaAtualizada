package com.curso.services;

import com.curso.domains.Fornecedor;
import com.curso.domains.Laboratorio;
import com.curso.domains.dtos.FornecedorDTO;
import com.curso.repositories.FornecedorRepository;
import com.curso.services.exceptions.DataIntegrityViolationException;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepo;

    public List<FornecedorDTO> findAll(){
        return fornecedorRepo.findAll().stream().map(obj -> new FornecedorDTO(obj)).collect(Collectors.toList());
    }

    public Fornecedor findById(int id){
        Optional<Fornecedor> obj = fornecedorRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Fornecedor não encontrado! ID: "+id));
    }
    public Fornecedor findByCnpj(String cnpj){
        Optional<Fornecedor> obj = fornecedorRepo.findByCnpj(cnpj);
        return obj.orElse(null);
    }
    public Fornecedor create(FornecedorDTO dto){
        dto.setId(null);
        Fornecedor obj = new Fornecedor(dto);
        return fornecedorRepo.save(obj);
    }

    public Fornecedor update(Integer id, FornecedorDTO objDto){
        objDto.setId(id);
        Fornecedor oldObj = findById(id);
        oldObj = new Fornecedor(objDto);
        return fornecedorRepo.save(oldObj);
    }

    public void delete(Integer id){
        Fornecedor obj = findById(id);
        if(obj.getMedicamentos().size()>0){
            throw new DataIntegrityViolationException("Fornecedor não pode ser deletado pois possui Medicamentos vinculados!");
        }
        fornecedorRepo.deleteById(id);
    }
}
