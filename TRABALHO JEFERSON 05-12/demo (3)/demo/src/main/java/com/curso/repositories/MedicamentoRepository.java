package com.curso.repositories;

import com.curso.domains.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    Optional<Medicamento> findByNome(String nome);

    Optional<Medicamento> findByPrinAtivo(String prinAtivo);
}
