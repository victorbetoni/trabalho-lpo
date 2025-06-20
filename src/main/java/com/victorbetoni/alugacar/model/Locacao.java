package com.victorbetoni.alugacar.model;

import com.victorbetoni.alugacar.model.veiculo.Veiculo;
import com.victorbetoni.alugacar.model.veiculo.VeiculoI;
import java.util.Calendar;

/**
 *
 * @author VictorHugoBetoni
 */
public class Locacao {
    
    private int dias;
    private double valor;
    private Calendar data;
    private Cliente cliente;

    public Locacao(int dias, double valor, Calendar data, Cliente cliente) {
        this.dias = dias;
        this.valor = valor;
        this.data = data;
        this.cliente = cliente;
    }

    public int getDias() {
        return dias;
    }

    public double getValor() {
        return valor;
    }

    public Calendar getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
}
