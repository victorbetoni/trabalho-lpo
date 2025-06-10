/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.model.veiculo;

import com.victorbetoni.alugacar.enums.Categoria;
import com.victorbetoni.alugacar.enums.Estado;
import com.victorbetoni.alugacar.enums.Marca;
import com.victorbetoni.alugacar.enums.ModeloAutomovel;
import com.victorbetoni.alugacar.model.Locacao;

/**
 *
 * @author VictorHugoBetoni
 */
public class Automovel extends Veiculo {
    
    private ModeloAutomovel modelo;

    public Automovel(String placa, ModeloAutomovel modelo, Marca marca, Estado estado, Categoria categoria, Locacao locacao, double valorDeCompra, int ano) {
        super(placa, marca, estado, categoria, locacao, valorDeCompra, ano);
        this.modelo = modelo;
    }
    
    @Override
    public double getValorDiariaLocacao() {
        return switch (this.getCategoria()) {
            case Categoria.POPULAR -> 100D;
            case Categoria.INTERMEDIARIO -> 300D;
            default -> 450D;
        };
    }

    public ModeloAutomovel getModelo() {
        return modelo;
    }
    
    
    
}
