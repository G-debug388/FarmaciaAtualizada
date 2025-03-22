package com.curso.domains.dtos;

import com.curso.domains.Laboratorio;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LaboratorioDTO {


    private Integer id;

    @NotNull(message = "O campo Nome não pode ser nulo")
    @NotBlank(message = "O campo Nome não pode ser vazio")
    private String nomeLab;

    @NotNull(message = "O campo CNPJ não pode ser nulo")
    @NotBlank(message = "O campo CNPJ não pode ser vazio")
    private String cnpj;

    public LaboratorioDTO(){}

    public LaboratorioDTO(Laboratorio laboratorio) {
        this.id = laboratorio.getId();
        this.nomeLab = laboratorio.getNomeLab();
        this.cnpj = laboratorio.getCnpj();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo Nome não pode ser nulo") @NotBlank(message = "O campo Nome não pode ser vazio") String getNomeLab() {
        return nomeLab;
    }

    public void setNomeLab(@NotNull(message = "O campo Nome não pode ser nulo") @NotBlank(message = "O campo Nome não pode ser vazio") String nomeLab) {
        this.nomeLab = nomeLab;
    }

    public @NotNull(message = "O campo CNPJ não pode ser nulo") @NotBlank(message = "O campo CNPJ não pode ser vazio") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo CNPJ não pode ser nulo") @NotBlank(message = "O campo CNPJ não pode ser vazio") String cnpj) {
        this.cnpj = cnpj;
    }


}

