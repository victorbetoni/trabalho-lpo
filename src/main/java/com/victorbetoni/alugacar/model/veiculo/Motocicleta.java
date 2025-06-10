package com.victorbetoni.alugacar.model.veiculo;

import com.victorbetoni.alugacar.enums.Categoria;
import com.victorbetoni.alugacar.enums.Estado;
import com.victorbetoni.alugacar.enums.Marca;
import com.victorbetoni.alugacar.enums.ModeloMotocicleta;
import com.victorbetoni.alugacar.model.Locacao;

/**
 *
 * @author VictorHugoBetoni
 */
public class Motocicleta extends Veiculo {
    
    private ModeloMotocicleta modelo;

    public Motocicleta(String placa, ModeloMotocicleta modelo, Marca marca, Estado estado, Categoria categoria, Locacao locacao, double valorDeCompra, int ano) {
        super(placa, marca, estado, categoria, locacao, valorDeCompra, ano);
        this.modelo = modelo;
    }
    
    @Override
    public double getValorDiariaLocacao() {
        return switch (this.getCategoria()) {
            case Categoria.POPULAR -> 70D;
            case Categoria.INTERMEDIARIO -> 200D;
            default -> 350D;
        };
    }
    
    public ModeloMotocicleta getModelo() {
        return modelo;
    }
    
    
    
}
