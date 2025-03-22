package com.curso.domains;

import com.curso.domains.enums.PersonType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "tb_user")

public class User extends Person implements Serializable {
    private static final long serialVersionUID = 1L;

    public User() {
        super();
        addPersonType(PersonType.USER);
    }

    public User(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addPersonType(PersonType.USER);
    }
}