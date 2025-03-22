package com.curso.services;

import com.curso.domains.ServiceOrder;
import com.curso.dtos.ServiceOrderDTO;
import com.curso.repositories.ServiceOrderRepository;
import com.curso.repositories.TechnicianRepository;
import com.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private TechnicianRepository technicianRepository;

    @Autowired
    private UserRepository userRepository;

    public ServiceOrder findById(UUID id) {
        Optional<ServiceOrder> obj = serviceOrderRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Ordem de Serviço não encontrada com ID: " + id));
    }

    public List<ServiceOrder> findAll() {
        return serviceOrderRepository.findAll();
    }

    public ServiceOrder create(ServiceOrderDTO dto) {
        ServiceOrder obj = new ServiceOrder(
                null,
                dto.getDescription(),
                technicianRepository.findById(dto.getTechnicianId()).orElseThrow(() -> new RuntimeException("Técnico não encontrado")),
                userRepository.findById(dto.getUserId()).orElseThrow(() -> new RuntimeException("Usuário não encontrado"))
        );
        return serviceOrderRepository.save(obj);
    }

    public ServiceOrder update(UUID id, ServiceOrderDTO dto) {
        ServiceOrder obj = findById(id);
        obj.setDescription(dto.getDescription());
        obj.setClosedAt(dto.getClosedAt());
        return serviceOrderRepository.save(obj);
    }

    public void delete(UUID id) {
        ServiceOrder obj = findById(id);
        serviceOrderRepository.delete(obj);
    }
}
