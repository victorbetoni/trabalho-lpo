/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.views.tables;

import com.victorbetoni.alugacar.Utils;
import com.victorbetoni.alugacar.model.Locacao;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.Motocicleta;
import com.victorbetoni.alugacar.model.veiculo.Van;
import com.victorbetoni.alugacar.model.veiculo.VeiculoI;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author VictorHugoBetoni
 */
public class TabelaVeiculoLocado extends AbstractTableModel {
    private final String[] colunas = {"Cliente", "Placa", "Marca", "Modelo", "Ano", "Dt. Locacao","Preço Diária", "Qtd. Dias", "Total"};
    private final List<VeiculoI> veiculos;
    
    public TabelaVeiculoLocado(List<VeiculoI> veiculos) {
        this.veiculos = veiculos;
    }

    public List<VeiculoI> getVeiculos() {
        return veiculos;
    }
    
    @Override
    public int getRowCount() {
        return veiculos.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        VeiculoI veiculo = veiculos.get(rowIndex);
        if(veiculo == null) {
            return "";
        }
        Locacao loc = veiculo.getLocacao();
        if(loc == null) {
            return "";
        }
        String modelo = "";
        if(columnIndex == 3) {
            if(veiculo instanceof Van) {
                modelo = ((Van) veiculo).getModelo().getModelo();
            } else if (veiculo instanceof Motocicleta) {
                modelo = ((Motocicleta) veiculo).getModelo().getModelo();
            } else {
                modelo = ((Automovel) veiculo).getModelo().getModelo();
            }
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dtLocacao = sdf.format(loc.getData().getTime());
        
        switch (columnIndex) {
            case 0:
                return loc.getCliente().getNome() + " " + loc.getCliente().getSobrenome();
            case 1:
                return veiculo.getPlaca();
            case 2:
                return veiculo.getMarca().getNome();
            case 3:
                return modelo;
            case 4:
                return veiculo.getAno();
            case 5:
                return dtLocacao;
            case 6:
                return Utils.formatarMoeda(veiculo.getValorDiariaLocacao());
            case 7:
                return loc.getDias();
            case 8:
                return Utils.formatarMoeda(loc.getValor());
            default:
                return null;
        }

    }
}
