package com.curso.domains;

import com.curso.domains.dtos.MedicamentoDTO;
import com.curso.domains.enums.Disponibilidade;
import com.curso.domains.enums.Validade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_medicamento")
    private Long id;

    @NotNull @NotBlank
    private String prinAtivo;

    @NotNull @NotBlank
    private String und;

    @NotNull @NotBlank
    private String dosagem;

    @NotNull @NotBlank
    private String nome;

    @NotNull @NotBlank
    private String classe;

    @NotNull @NotBlank
    private String forma;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    private BigDecimal valor;

    @NotNull
    private int qtd;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCad;

    @ManyToOne
    @JoinColumn(name="idfornecedor")
    private Fornecedor fornecedor;

    @ManyToOne
    @JoinColumn(name="idlaboratorio")
    private Laboratorio laboratorio;

    @Enumerated(EnumType.ORDINAL)
    @JoinColumn(name = "disponibilidade")
    private Disponibilidade disponibilidade;

    @Enumerated
    @JoinColumn(name = "validade")
    private Validade validade;

    public Medicamento() {
        this.valor = BigDecimal.ZERO;
        this.disponibilidade = Disponibilidade.DISPONIVEL;
        this.validade = Validade.DENTRODAVALIDADE;
    }

    public Medicamento(Long id, String prinAtivo, String und, String dosagem, String nome, String classe, String forma, BigDecimal valor, int qtd, LocalDate dataCad, Fornecedor fornecedor, Laboratorio laboratorio, Disponibilidade disponibilidade, Validade validade) {
        this.id = id;
        this.prinAtivo = prinAtivo;
        this.und = und;
        this.dosagem = dosagem;
        this.nome = nome;
        this.classe = classe;
        this.forma = forma;
        this.valor = valor;
        this.qtd = qtd;
        this.dataCad = dataCad;
        this.fornecedor = fornecedor;
        this.laboratorio = laboratorio;
        this.disponibilidade = disponibilidade;
        this.validade = validade;
    }

    public Medicamento(MedicamentoDTO dto){
        this.id = dto.getId();
        this.prinAtivo = dto.getPrinAtivo();
        this.und = dto.getUnd();
        this.dosagem = dto.getDosagem();
        this.nome = dto.getNome();
        this.classe = dto.getClasse();
        this.forma = dto.getForma();
        this.valor = dto.getValor();
        this.qtd = dto.getQtd();
        this.dataCad = dto.getDataCad();
        this.fornecedor = new Fornecedor();
        this.fornecedor.setId(dto.getFornecedor());
        this.laboratorio = new Laboratorio();
        this.laboratorio.setId(dto.getLaboratorio());
        this.disponibilidade = Disponibilidade.toEnum(dto.getDisponibilidade());
        this.validade = Validade.toEnum(dto.getValidade());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getPrinAtivo() {
        return prinAtivo;
    }

    public void setPrinAtivo(@NotNull @NotBlank String prinAtivo) {
        this.prinAtivo = prinAtivo;
    }

    public @NotNull @NotBlank String getUnd() {
        return und;
    }

    public void setUnd(@NotNull @NotBlank String und) {
        this.und = und;
    }

    public @NotNull @NotBlank String getDosagem() {
        return dosagem;
    }

    public void setDosagem(@NotNull @NotBlank String dosagem) {
        this.dosagem = dosagem;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public @NotNull @NotBlank String getClasse() {
        return classe;
    }

    public void setClasse(@NotNull @NotBlank String classe) {
        this.classe = classe;
    }

    public @NotNull @NotBlank String getForma() {
        return forma;
    }

    public void setForma(@NotNull @NotBlank String forma) {
        this.forma = forma;
    }

    public @NotNull @Digits(integer = 15, fraction = 2) BigDecimal getValor() {
        return valor;
    }

    public void setValor(@NotNull @Digits(integer = 15, fraction = 2) BigDecimal valor) {
        this.valor = valor;
    }

    @NotNull
    public int getQtd() {
        return qtd;
    }

    public void setQtd(@NotNull int qtd) {
        this.qtd = qtd;
    }

    public LocalDate getDataCad() {
        return dataCad;
    }

    public void setDataCad(LocalDate dataCad) {
        this.dataCad = dataCad;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public Validade getValidade() {
        return validade;
    }

    public void setValidade(Validade validade) {
        this.validade = validade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicamento that = (Medicamento) o;
        return qtd == that.qtd && Objects.equals(id, that.id) && Objects.equals(prinAtivo, that.prinAtivo) && Objects.equals(und, that.und) && Objects.equals(dosagem, that.dosagem) && Objects.equals(nome, that.nome) && Objects.equals(classe, that.classe) && Objects.equals(forma, that.forma) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prinAtivo, und, dosagem, nome, classe, forma, valor, qtd);
    }
}
