/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.enums;

import static com.victorbetoni.alugacar.enums.ModeloMotocicleta.values;
import java.util.stream.Stream;

/**
 *
 * @author VictorHugoBetoni
 */
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
