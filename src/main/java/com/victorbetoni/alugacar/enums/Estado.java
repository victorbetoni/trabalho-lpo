/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.enums;

/**
 *
 * @author VictorHugoBetoni
 */
public enum Estado {
    
    NOVO("Novo"), DISPONIVEL("Disponível"), LOCADO("Locado"), VENDIDO("Vendido");
    
    private String desc;
    
    private Estado(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
    
    
}
