package com.curso.domains.dtos;

import com.curso.domains.Fornecedor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FornecedorDTO {


    private Integer id;

    @NotNull(message = "O campo Nome não pode ser nulo")
    @NotBlank(message = "O campo Nome não pode ser vazio")
    private String nomeFor;

    @NotNull(message = "O campo CNPJ não pode ser nulo")
    @NotBlank(message = "O campo CNPJ não pode ser vazio")
    private String cnpj;

    public FornecedorDTO(){}

    public FornecedorDTO(Fornecedor fornecedor) {
        this.id = fornecedor.getId();
        this.nomeFor = fornecedor.getNomeFor();
        this.cnpj = fornecedor.getCnpj();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotNull(message = "O campo Nome não pode ser nulo") @NotBlank(message = "O campo Nome não pode ser vazio") String getNomeFor() {
        return nomeFor;
    }

    public void setNomeFor(@NotNull(message = "O campo Nome não pode ser nulo") @NotBlank(message = "O campo Nome não pode ser vazio") String nomeFor) {
        this.nomeFor = nomeFor;
    }

    public @NotNull(message = "O campo CNPJ não pode ser nulo") @NotBlank(message = "O campo CNPJ não pode ser vazio") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotNull(message = "O campo CNPJ não pode ser nulo") @NotBlank(message = "O campo CNPJ não pode ser vazio") String cnpj) {
        this.cnpj = cnpj;
    }


}
