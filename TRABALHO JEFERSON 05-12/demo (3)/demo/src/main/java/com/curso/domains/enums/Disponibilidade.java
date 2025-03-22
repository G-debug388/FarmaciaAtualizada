package com.curso.domains.enums;

public enum Disponibilidade {

    DISPONIVEL(0, "DISPONÍVEL"), INDISPONIVEL(1, "INDISPONÍVEL");

    private Integer id;
    private String disponibilidade;

    Disponibilidade(Integer id, String disponibilidade) {
        this.id = id;
        this.disponibilidade = disponibilidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public static Disponibilidade toEnum(Integer id){
        if(id==null) return null;
        for(Disponibilidade x : Disponibilidade.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Disponibilidade inválida");
    }
}
