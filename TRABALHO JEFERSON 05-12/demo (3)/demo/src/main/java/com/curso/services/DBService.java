package com.curso.services;

import com.curso.domains.*;
import com.curso.domains.enums.Disponibilidade;
import com.curso.domains.enums.Validade;
import com.curso.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class DBService implements CommandLineRunner {

    @Autowired
    private FornecedorRepository fornecedorRepo;

    @Autowired
    private LaboratorioRepository laboratorioRepo;

    @Autowired
    private MedicamentoRepository medicamentoRepo;

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    public void initDB() {
        // Populando Fornecedores e Laboratórios
        Fornecedor fornecedor01 = new Fornecedor(null, "Farmacia São João", "08658785000279");
        Fornecedor fornecedor02 = new Fornecedor(null, "Drogaria São Paulo", "89.158.7980003-03");

        Laboratorio laboratorio01 = new Laboratorio(null, "Fresênios", "45.487.5320002-77");
        Laboratorio laboratorio02 = new Laboratorio(null, "Neo Química", "12.587.6980003-55");

        // Populando Medicamentos
        Medicamento medicamento01 = new Medicamento(null, "Dipirona monohidratada", "ML", "500mg/ml", "Dipimed", "Analgésico", "Gotas", new BigDecimal("3.00"), 500, LocalDate.now(), fornecedor01, laboratorio01, Disponibilidade.DISPONIVEL, Validade.DENTRODAVALIDADE);
        Medicamento medicamento02 = new Medicamento(null, "Dipirona monohidratada / Citrato de orfenadrina / Cafeína anidra", "MG", "300mg + 35mg + 50mg", "Dorflex", "Analgésico e Relaxante muscular", "Comprimido", new BigDecimal("9.00"), 100, LocalDate.now(), fornecedor02, laboratorio02, Disponibilidade.DISPONIVEL, Validade.DENTRODAVALIDADE);

        // Populando Técnico e Usuário
        Technician t1 = new Technician(null, "Carlos Silva", "11111111111", "carlos@tecnico.com", "123");
        User u1 = new User(null, "Ana Paula", "22222222222", "ana@cliente.com", "123");

        // Populando Ordens de Serviço
        ServiceOrder os1 = new ServiceOrder(null, "Instalação de sistema", t1, u1);
        ServiceOrder os2 = new ServiceOrder(null, "Manutenção preventiva", t1, u1);

        // Salvando no banco
        fornecedorRepo.saveAll(List.of(fornecedor01, fornecedor02));
        laboratorioRepo.saveAll(List.of(laboratorio01, laboratorio02));
        medicamentoRepo.saveAll(List.of(medicamento01, medicamento02));

        technicianRepository.save(t1);
        userRepository.save(u1);
        serviceOrderRepository.saveAll(List.of(os1, os2));
    }

    @Override
    public void run(String... args) throws Exception {
        initDB(); // Executa ao iniciar o projeto
    }
}
