/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.enums;

import static com.victorbetoni.alugacar.enums.ModeloAutomovel.values;
import static com.victorbetoni.alugacar.enums.ModeloVan.values;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author VictorHugoBetoni
 */
public enum ModeloMotocicleta {
    HONDA_CG160(Marca.HONDA, "CG 160"),
    HONDA_CB500F(Marca.HONDA, "CB 500F"),
    HONDA_AFRICA_TWIN(Marca.HONDA, "Africa Twin"),

    YAMAHA_FAZER250(Marca.YAMAHA, "Fazer 250"),
    YAMAHA_MT07(Marca.YAMAHA, "MT-07"),
    YAMAHA_R1(Marca.YAMAHA, "YZF-R1"),

    KAWASAKI_NINJA400(Marca.KAWASAKI, "Ninja 400"),
    KAWASAKI_Z900(Marca.KAWASAKI, "Z900"),
    KAWASAKI_VERSYS650(Marca.KAWASAKI, "Versys 650"),

    DUCATI_MONSTER(Marca.DUCATI, "Monster"),
    DUCATI_PANIGALE_V4(Marca.DUCATI, "Panigale V4"),
    DUCATI_MULTISTRADA(Marca.DUCATI, "Multistrada V4"),

    SUZUKI_GSX_S750(Marca.SUZUKI, "GSX-S750"),
    SUZUKI_HAYABUSA(Marca.SUZUKI, "Hayabusa"),
    SUZUKI_VSTROM650(Marca.SUZUKI, "V-Strom 650"),

    BMW_G310R(Marca.BMW, "G 310 R"),
    BMW_S1000RR(Marca.BMW, "S 1000 RR"),
    BMW_R1250GS(Marca.BMW, "R 1250 GS");

    private Marca marca;
    private String modelo;
    
    private ModeloMotocicleta(Marca marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Marca getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }
    
    public List<ModeloMotocicleta> buscarPorMarca(Marca marca) {
        return Stream.of(values()).filter(x -> x.marca == marca).toList();
    }
    
    public static ModeloMotocicleta getByName(String nome) {
         return Stream.of(values()).filter(x -> x.getModelo().equalsIgnoreCase(nome)).findFirst().get();
    }
    
    
}
