package com.victorbetoni.alugacar.views.tables;

import com.victorbetoni.alugacar.Utils;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.Motocicleta;
import com.victorbetoni.alugacar.model.veiculo.Van;
import com.victorbetoni.alugacar.model.veiculo.VeiculoI;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author VictorHugoBetoni
 */
public class TabelaVeiculos extends AbstractTableModel {
    
    private final String[] colunas = {"Placa", "Marca", "Modelo", "Ano", "Preço Diária"};
    private final List<VeiculoI> veiculos;
    
    public TabelaVeiculos(List<VeiculoI> veiculos) {
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
        String modelo = "";
        if(columnIndex == 2) {
            if(veiculo instanceof Van) {
                modelo = ((Van) veiculo).getModelo().getModelo();
            } else if (veiculo instanceof Motocicleta) {
                modelo = ((Motocicleta) veiculo).getModelo().getModelo();
            } else {
                modelo = ((Automovel) veiculo).getModelo().getModelo();
            }
        }
        return switch (columnIndex) {
            case 0 -> veiculo.getPlaca();
            case 1 -> veiculo.getMarca().getNome();
            case 2 -> modelo;
            case 3 -> veiculo.getAno();
            case 4 -> Utils.formatarMoeda(veiculo.getValorDiariaLocacao());
            default -> null;
        };
    }
    
}
