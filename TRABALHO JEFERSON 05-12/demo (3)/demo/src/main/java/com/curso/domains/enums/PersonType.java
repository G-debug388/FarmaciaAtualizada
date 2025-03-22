package com.curso.domains.enums;
public enum PersonType {
    ADMIN(0, "ADMIN"),
    USER(1, "USER"),
    TECHNICIAN(2, "TECHNICIAN");

    private Integer code;
    private String description;

    private PersonType(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public static PersonType toEnum(Integer code) {
        if (code == null) return null;
        for (PersonType x : PersonType.values()) {
            if (code.equals(x.getCode())) {
                return x;
            }
        }
        throw new IllegalArgumentException("Tipo inválido: " + code);
    }
}
