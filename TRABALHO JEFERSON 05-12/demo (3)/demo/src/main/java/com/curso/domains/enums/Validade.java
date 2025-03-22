package com.curso.domains.enums;

public enum Validade {

    DENTRODAVALIDADE(0, "DENTRO DA VALIDADE"), VENCIDO(1, "VENCIDO");

    private Integer id;
    private String situacao;

    Validade(Integer id, String situacao) {
        this.id = id;
        this.situacao = situacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public static Validade toEnum(Integer id){
        if(id==null) return null;
        for(Validade x : Validade.values()){
            if(id.equals(x.getId())){
                return x;
            }
        }
        throw new IllegalArgumentException("Validade inválida");
    }
}
