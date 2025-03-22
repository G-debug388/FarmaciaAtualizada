package com.curso.domains;

import com.curso.domains.enums.PersonType;
import jakarta.persistence.Entity;
import java.io.Serializable;

@Entity
public class Technician extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public Technician() {
        super();
        addPersonType(PersonType.TECHNICIAN);
    }

    public Technician(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addPersonType(PersonType.TECHNICIAN);
    }
}
