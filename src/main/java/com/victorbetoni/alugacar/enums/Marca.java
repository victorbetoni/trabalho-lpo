/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.enums;

import static com.victorbetoni.alugacar.enums.ModeloVan.values;
import java.util.stream.Stream;

/**
 *
 * @author VictorHugoBetoni
 */
public enum Marca {
    
    GM("General Motors"),
    VW("Volkzwagen"),
    MERCEDES("Mercedez-Benz"),
    BMW("BMW"),
    PEUGEOT("Peugeot"),
    CITROEN("Citroen"),
    HONDA("Honda"),
    SUZUKI("Suzuki"),
    KAWASAKI("Kawasaki"),
    YAMAHA("Yamaha"),
    DUCATI("Ducati"),
    TOYOTA("Toyota");
    
    
    private String nome;
    
    private Marca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    
    public static Marca getByName(String nome) {
         return Stream.of(values()).filter(x -> x.getNome().equalsIgnoreCase(nome)).findFirst().get();
    }
    
}
