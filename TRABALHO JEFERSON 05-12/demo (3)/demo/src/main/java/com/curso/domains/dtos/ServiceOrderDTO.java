package com.curso.dtos;

import com.curso.domains.ServiceOrder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class ServiceOrderDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;
    private Integer technicianId;
    private Integer userId;

    public ServiceOrderDTO() {}

    public ServiceOrderDTO(ServiceOrder obj) {
        this.id = obj.getId();
        this.description = obj.getDescription();
        this.createdAt = obj.getCreatedAt();
        this.closedAt = obj.getClosedAt();
        this.technicianId = obj.getTechnician().getId();
        this.userId = obj.getUser().getId();
    }

    // Getters e Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getClosedAt() { return closedAt; }
    public void setClosedAt(LocalDateTime closedAt) { this.closedAt = closedAt; }

    public Integer getTechnicianId() { return technicianId; }
    public void setTechnicianId(Integer technicianId) { this.technicianId = technicianId; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
}
