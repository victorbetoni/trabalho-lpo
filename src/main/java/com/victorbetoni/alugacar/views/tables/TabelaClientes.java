/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.views.tables;

import com.victorbetoni.alugacar.model.Cliente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author VictorHugoBetoni
 */
public class TabelaClientes extends AbstractTableModel {
    
    private final String[] colunas = {"Nome", "CPF", "RG", "Endereço"};
    private final List<Cliente> clientes;
    
    public TabelaClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
    
    

    @Override
    public int getRowCount() {
        return clientes.size();
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
        Cliente cliente = clientes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return cliente.getNome() + " " + cliente.getSobrenome();
            case 1:
                return cliente.getCpf();
            case 2:
                return cliente.getRg();
            case 3:
                return String.format("%s - %d, %s, %s - %s",
                        cliente.getRua(),
                        cliente.getNumero(),
                        cliente.getBairro(),
                        cliente.getCidade(),
                        cliente.getEstado());
            default:
                return null;
        }
    }


}
