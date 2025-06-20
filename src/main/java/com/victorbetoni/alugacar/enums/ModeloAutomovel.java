/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.enums;

import static com.victorbetoni.alugacar.enums.ModeloMotocicleta.values;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author VictorHugoBetoni
 */
public enum ModeloAutomovel {
    
    VW_GOL(Marca.VW, "Gol"),
    VW_GOLF(Marca.VW, "Golf"),
    VW_JETTA(Marca.VW, "Jetta"),
    
    GM_CELTA(Marca.GM, "Celta"),
    GM_CRUZE(Marca.GM, "Cruze"),
    GM_ONIX(Marca.GM, "Onix"),
    
    A200(Marca.MERCEDES, "A200"),
    C200(Marca.MERCEDES, "C200"),
    AMG_ONE(Marca.MERCEDES, "AMG One"),
    
    BMW_320I(Marca.BMW, "320i"),
    M3(Marca.BMW, "M3 Competition"),
    M5(Marca.BMW, "M5 Competition"), 
    
    C3(Marca.CITROEN, "C3"),
    BASALT(Marca.CITROEN, "Basalt"),
    C5(Marca.CITROEN, "C5"),
    
    PG_206(Marca.PEUGEOT, "206"),
    PG_308(Marca.PEUGEOT, "308"),
    PG_2008(Marca.PEUGEOT, "2008"),
    
    FIT(Marca.HONDA, "Fit"),
    CIVIC(Marca.HONDA, "Civic"),
    ACCORD(Marca.HONDA, "Accord"),
    
    ETIOS(Marca.TOYOTA, "Etios"),
    YARIS(Marca.TOYOTA, "Yaris"),
    COROLLA(Marca.TOYOTA, "Corolla");
    
    private Marca marca;
    private String modelo;

    private ModeloAutomovel(Marca marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    
     public List<ModeloAutomovel> buscarPorMarca(Marca marca) {
        return Stream.of(values()).filter(x -> x.marca == marca).collect(Collectors.toList());
    }
    
     public static ModeloAutomovel getByName(String nome) {
         return Stream.of(values()).filter(x -> x.getModelo().equalsIgnoreCase(nome)).findFirst().get();
     }
    
}
