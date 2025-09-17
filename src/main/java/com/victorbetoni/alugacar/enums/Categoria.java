package com.victorbetoni.alugacar.enums;

import static com.victorbetoni.alugacar.enums.ModeloMotocicleta.values;
import java.util.stream.Stream;

public enum Categoria {
    
    LUXO("Luxo"), INTERMEDIARIO("Intermediário"), POPULAR("Popular");
    
    private String desc;

    private Categoria(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
    
    public static Categoria getByName(String nome) {
         return Stream.of(values()).filter(x -> x.getDesc().equalsIgnoreCase(nome)).findFirst().get();
    }
}
