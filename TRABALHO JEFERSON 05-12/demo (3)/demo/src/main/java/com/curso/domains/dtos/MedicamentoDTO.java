package com.curso.domains.dtos;

import com.curso.domains.Fornecedor;
import com.curso.domains.Laboratorio;
import com.curso.domains.Medicamento;
import com.curso.domains.enums.Disponibilidade;
import com.curso.domains.enums.Validade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicamentoDTO {

    private Long id;

    @NotNull(message = "O campo do princípio ativo não pode ser nulo")
    @NotBlank(message = "O campo do princípio ativo não pode ser vazio")
    private String prinAtivo;

    @NotNull(message = "O campo unidade não pode ser nulo")
    @NotBlank(message = "O campo unidade não pode ser vazio")
    private String und;

    @NotNull(message = "O campo dosagem não pode ser nulo")
    @NotBlank(message = "O campo dosagem não pode ser vazio")
    private String dosagem;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode ser vazio")
    private String nome;

    @NotNull(message = "O campo classe não pode ser nulo")
    @NotBlank(message = "O campo classe não pode ser vazio")
    private String classe;

    @NotNull(message = "O campo forma não pode ser nulo")
    @NotBlank(message = "O campo forma não pode ser vazio")
    private String forma;

    @NotNull(message = "O campo valor não pode ser nulo")
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valor;

    @NotNull(message = "O campo quantidade não pode ser nulo")
    private int qtd;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCad;

    @NotNull(message = "O campo Fornecedor é requerido")
    private int fornecedor;
    private String nomeFor;

    @NotNull(message = "O campo Laboratório é requerido")
    private int laboratorio;
    private String nomeLab;

    private int disponibilidade;

    private int validade;

    public MedicamentoDTO(){}

    public MedicamentoDTO(Medicamento medicamento) {
        this.id = medicamento.getId();
        this.prinAtivo = medicamento.getPrinAtivo();
        this.und = medicamento.getUnd();
        this.dosagem = medicamento.getDosagem();
        this.nome = medicamento.getNome();
        this.classe = medicamento.getClasse();
        this.forma = medicamento.getForma();
        this.valor = medicamento.getValor();
        this.qtd = medicamento.getQtd();
        this.dataCad = medicamento.getDataCad();
        this.fornecedor = medicamento.getFornecedor().getId();
        this.nomeFor = medicamento.getFornecedor().getNomeFor();
        this.laboratorio = medicamento.getLaboratorio().getId();
        this.nomeLab = medicamento.getLaboratorio().getNomeLab();
        this.disponibilidade = medicamento.getDisponibilidade().getId();
        this.validade = medicamento.getValidade().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo do princípio ativo não pode ser nulo") @NotBlank(message = "O campo do princípio ativo não pode ser vazio") String getPrinAtivo() {
        return prinAtivo;
    }

    public void setPrinAtivo(@NotNull(message = "O campo do princípio ativo não pode ser nulo") @NotBlank(message = "O campo do princípio ativo não pode ser vazio") String prinAtivo) {
        this.prinAtivo = prinAtivo;
    }

    public @NotNull(message = "O campo unidade não pode ser nulo") @NotBlank(message = "O campo unidade não pode ser vazio") String getUnd() {
        return und;
    }

    public void setUnd(@NotNull(message = "O campo unidade não pode ser nulo") @NotBlank(message = "O campo unidade não pode ser vazio") String und) {
        this.und = und;
    }

    public @NotNull(message = "O campo dosagem não pode ser nulo") @NotBlank(message = "O campo dosagem não pode ser vazio") String getDosagem() {
        return dosagem;
    }

    public void setDosagem(@NotNull(message = "O campo dosagem não pode ser nulo") @NotBlank(message = "O campo dosagem não pode ser vazio") String dosagem) {
        this.dosagem = dosagem;
    }

    public @NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode ser vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode ser vazio") String nome) {
        this.nome = nome;
    }

    public @NotNull(message = "O campo classe não pode ser nulo") @NotBlank(message = "O campo classe não pode ser vazio") String getClasse() {
        return classe;
    }

    public void setClasse(@NotNull(message = "O campo classe não pode ser nulo") @NotBlank(message = "O campo classe não pode ser vazio") String classe) {
        this.classe = classe;
    }

    public @NotNull(message = "O campo forma não pode ser nulo") @NotBlank(message = "O campo forma não pode ser vazio") String getForma() {
        return forma;
    }

    public void setForma(@NotNull(message = "O campo forma não pode ser nulo") @NotBlank(message = "O campo forma não pode ser vazio") String forma) {
        this.forma = forma;
    }

    public @NotNull(message = "O campo valor não pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal getValor() {
        return valor;
    }

    public void setValor(@NotNull(message = "O campo valor não pode ser nulo") @Digits(integer = 15, fraction = 2) BigDecimal valor) {
        this.valor = valor;
    }

    @NotNull(message = "O campo quantidade não pode ser nulo")
    public int getQtd() {
        return qtd;
    }

    public void setQtd(@NotNull(message = "O campo quantidade não pode ser nulo") int qtd) {
        this.qtd = qtd;
    }

    public LocalDate getDataCad() {
        return dataCad;
    }

    public void setDataCad(LocalDate dataCad) {
        this.dataCad = dataCad;
    }

    @NotNull(message = "O campo Fornecedor é requerido")
    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(@NotNull(message = "O campo Fornecedor é requerido") int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getNomeFor() {
        return nomeFor;
    }

    public void setNomeFor(String nomeFor) {
        this.nomeFor = nomeFor;
    }

    @NotNull(message = "O campo Laboratório é requerido")
    public int getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(@NotNull(message = "O campo Laboratório é requerido") int laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getNomeLab() {
        return nomeLab;
    }

    public void setNomeLab(String nomeLab) {
        this.nomeLab = nomeLab;
    }

    public int getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(int disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public int getValidade() {
        return validade;
    }

    public void setValidade(int validade) {
        this.validade = validade;
    }
}
