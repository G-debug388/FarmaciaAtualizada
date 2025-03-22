package com.curso.dtos;

import com.curso.domains.User;
import com.curso.domains.enums.PersonType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;

    @NotBlank(message = "O email é obrigatório")
    private String email;

    @NotBlank(message = "A senha é obrigatória")
    private String password;

    @NotNull(message = "O tipo é obrigatório")
    private Set<Integer> personType;

    public UserDTO() {}

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.personType = user.getPersonType().stream().map(PersonType::getCode).collect(Collectors.toSet());
    }

    // Getters e Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<Integer> getPersonType() { return personType; }
    public void setPersonType(Set<Integer> personType) { this.personType = personType; }
}
