package com.curso.services;

import com.curso.domains.User;
import com.curso.dtos.UserDTO;
import com.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User create(UserDTO dto) {
        User obj = new User(null, dto.getName(), dto.getCpf(), dto.getEmail(), dto.getPassword());
        return repository.save(obj);
    }

    public User update(Integer id, UserDTO dto) {
        User obj = findById(id);
        obj.setName(dto.getName());
        obj.setCpf(dto.getCpf());
        obj.setEmail(dto.getEmail());
        obj.setPassword(dto.getPassword());
        return repository.save(obj);
    }

    public void delete(Integer id) {
        User obj = findById(id);
        repository.delete(obj);
    }
}
