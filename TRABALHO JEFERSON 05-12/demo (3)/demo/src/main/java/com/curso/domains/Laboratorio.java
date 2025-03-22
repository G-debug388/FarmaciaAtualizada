package com.curso.domains;

import com.curso.domains.dtos.FornecedorDTO;
import com.curso.domains.dtos.LaboratorioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="laboratorio")
public class Laboratorio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_laboratorio")
    private Integer id;

    @NotNull @NotBlank
    private String nomeLab;

    @NotNull @NotBlank
    private String cnpj;

    @JsonIgnore
    @OneToMany(mappedBy = "laboratorio")
    private List<Medicamento> medicamentos = new ArrayList<>();

    public Laboratorio() {}

    public Laboratorio(Integer id, String nomeLab, String cnpj) {
        this.id = id;
        this.nomeLab = nomeLab;
        this.cnpj = cnpj;
    }

    public Laboratorio(LaboratorioDTO dto){
        this.id = dto.getId();
        this.nomeLab = dto.getNomeLab();
        this.cnpj = dto.getCnpj();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeLab() {
        return nomeLab;
    }

    public void setNomeLab(String nomeLab) {
        this.nomeLab = nomeLab;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laboratorio that = (Laboratorio) o;
        return Objects.equals(id, that.id) && Objects.equals(nomeLab, that.nomeLab) && Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeLab, cnpj);
    }
}
