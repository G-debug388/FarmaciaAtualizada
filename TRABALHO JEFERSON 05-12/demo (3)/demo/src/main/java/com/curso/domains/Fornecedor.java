package com.curso.domains;

import com.curso.domains.dtos.FornecedorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="fornecedor")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fornecedor")
    private Integer id;

    @NotNull @NotBlank
    private String nomeFor;

    @NotNull @NotBlank
    private String cnpj;

    @JsonIgnore
    @OneToMany(mappedBy = "fornecedor")
    private List<Medicamento> medicamentos = new ArrayList<>();

    public Fornecedor () {}

    public Fornecedor(Integer id, String nomeFor, String cnpj) {
        this.id = id;
        this.nomeFor = nomeFor;
        this.cnpj = cnpj;
    }

    public Fornecedor(FornecedorDTO dto){
        this.id = dto.getId();
        this.nomeFor = dto.getNomeFor();
        this.cnpj = dto.getCnpj();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeFor() {
        return nomeFor;
    }

    public void setNomeFor(String nomeFor) {
        this.nomeFor = nomeFor;
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
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(id, that.id) && Objects.equals(nomeFor, that.nomeFor) && Objects.equals(cnpj, that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeFor, cnpj);
    }
}
