/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.model.veiculo;

import com.victorbetoni.alugacar.enums.Categoria;
import com.victorbetoni.alugacar.enums.Estado;
import com.victorbetoni.alugacar.enums.Marca;
import com.victorbetoni.alugacar.model.Cliente;
import com.victorbetoni.alugacar.model.Locacao;
import java.util.Calendar;

/**
 *
 * @author VictorHugoBetoni
 */
public abstract class Veiculo implements VeiculoI {

    private String placa;
    private Marca marca;
    private Estado estado;
    private Categoria categoria;
    private Locacao locacao;
    private double valorDeCompra;
    private int ano;

    public Veiculo(String placa, Marca marca, Estado estado, Categoria categoria, Locacao locacao, double valorDeCompra, int ano) {
        this.marca = marca;
        this.estado = estado;
        this.categoria = categoria;
        this.locacao = locacao;
        this.valorDeCompra = valorDeCompra;
        this.ano = ano;
        this.placa = placa;
    }
    
    @Override
    public int getAno() {
        return ano;
    }

    @Override
    public String getPlaca() {
        return placa;
    }

    @Override
    public Locacao getLocacao() {
        return locacao;
    }

    @Override
    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public Marca getMarca() {
        return marca;
    }

    @Override
    public Estado getEstado() {
        return estado;
    }

    @Override
    public double getValorParaVenda() {
        return valorDeCompra;
    }

    @Override
    public void devolver() {
        this.estado = Estado.DISPONIVEL;
        this.locacao = null;
    }

    @Override
    public void vender() {
        this.estado = Estado.VENDIDO;
        this.locacao = null;
    }

    @Override
    public void locar(int dias, Calendar data, Cliente cliente) {
        this.estado = Estado.LOCADO;
        this.locacao = new Locacao(dias, dias * getValorDiariaLocacao(), data, cliente);
    }
    
    
    
}
