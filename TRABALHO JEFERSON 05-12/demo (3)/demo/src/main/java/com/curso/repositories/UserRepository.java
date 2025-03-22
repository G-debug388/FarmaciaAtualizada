package com.curso.repositories;

import com.curso.domains.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByCpf(String cpf);
    User findByEmail(String email);
}
