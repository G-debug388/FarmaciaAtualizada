package com.curso.repositories;

import com.curso.domains.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Integer> {
    Technician findByCpf(String cpf);
    Technician findByEmail(String email);
}
