/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar;

import com.victorbetoni.alugacar.model.Locacao;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.VeiculoI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author VictorHugoBetoni
 */
public class GerenciadorVeiculos {
    
    private List<VeiculoI> veiculos = new ArrayList();

    public List<VeiculoI> getVeiculos() {
        return veiculos;
    }
    
    public void adicionarVeiculo(VeiculoI veiculo) {
        this.veiculos.add(veiculo);
    }
    
    public List<VeiculoI> buscarAutomoveis() {
        return veiculos.stream().filter(x -> x instanceof Automovel).collect(Collectors.toList());
    }
    
    public List<Locacao> buscarLocacoes() {
        return veiculos.stream().filter(x -> x.getLocacao() != null).map(x -> x.getLocacao()).collect(Collectors.toList());
    }
    
}
