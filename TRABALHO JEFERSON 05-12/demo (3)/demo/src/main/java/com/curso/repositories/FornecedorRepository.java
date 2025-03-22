package com.curso.repositories;

import com.curso.domains.Fornecedor;
import com.curso.domains.Laboratorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository <Fornecedor, Integer> {
    Optional<Fornecedor> findByCnpj(String cnpj);
}
