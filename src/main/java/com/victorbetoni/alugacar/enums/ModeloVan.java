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
public enum ModeloVan {
    
    PG_PARTNER(Marca.PEUGEOT, "Partner Rapid"),
    PG_EXPERT(Marca.PEUGEOT, "Expert"),
    PG_BOXER(Marca.PEUGEOT, "Boxer"),

    CITROEN_BERLINGO(Marca.CITROEN, "Berlingo"),
    CITROEN_JUMPY(Marca.CITROEN, "Jumpy"),
    CITROEN_JUMPER(Marca.CITROEN, "Jumper"),

    VW_KOMBI(Marca.VW, "Kombi"),
    VW_CRAFTER(Marca.VW, "Crafter"),
    VW_TRANSPORTER(Marca.VW, "Transporter"),

    GM_SPIN(Marca.GM, "Spin"),
    GM_MONTANA_VAN(Marca.GM, "Montana Van"),
    GM_EXpress(Marca.GM, "Chevrolet Express");
    
    private Marca marca;
    private String modelo;
    
    private ModeloVan(Marca marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    
    public List<ModeloVan> buscarPorMarca(Marca marca) {
        return Stream.of(values()).filter(x -> x.marca == marca).collect(Collectors.toList());
    }
    
    public static ModeloVan getByName(String nome) {
         return Stream.of(values()).filter(x -> x.getModelo().equalsIgnoreCase(nome)).findFirst().get();
    }
}
