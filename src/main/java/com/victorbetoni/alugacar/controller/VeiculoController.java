/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.controller;

import com.victorbetoni.alugacar.dao.ClienteDAO;
import com.victorbetoni.alugacar.dao.VeiculoDAO;
import com.victorbetoni.alugacar.enums.Categoria;
import com.victorbetoni.alugacar.enums.Marca;
import com.victorbetoni.alugacar.model.Cliente;
import com.victorbetoni.alugacar.model.Locacao;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.VeiculoI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author VictorHugoBetoni
 */
public class VeiculoController {
    
    private VeiculoDAO veiculosDAO = new VeiculoDAO();
    private ClienteDAO clientesDAO = new ClienteDAO();

    public List<VeiculoI> buscarVeiculos(int tipo, Marca marca, Categoria cat, String placa, String modelo, Boolean locado) throws Exception {
        return buscarVeiculos(tipo, marca, cat, placa, modelo, locado, null);
    }
    
    public List<VeiculoI> buscarVeiculos(int tipo, Marca marca, Categoria cat, String placa, String modelo, Boolean locado, Boolean vendido) throws Exception {
        try {
            return veiculosDAO.buscarVeiculos(tipo, marca, cat, placa, modelo, locado, vendido);
        } catch(SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao buscar veículos. Tente novamente.");
        }
    }
    
    public void adicionarVeiculo(VeiculoI veiculo) throws Exception {
        
        try {
            if(!buscarVeiculos(-1, null, null, veiculo.getPlaca().toUpperCase(), null, null).isEmpty()) {
                throw new Exception("Veículo com a mesma placa já cadastrado.");
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao inserir veículo. Tente novamente.");
        }
        
        this.veiculosDAO.salvarVeiculo(veiculo);
    }
    
    public List<Locacao> buscarLocacoes(int tipo, Marca marca, Categoria categoria) throws Exception {
        try {
            return veiculosDAO.buscarVeiculos(tipo, marca, categoria, null, null, true, null).stream().map(x -> x.getLocacao()).collect(Collectors.toList()); 
        } catch(SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao buscar veículos. Tente novamente.");
        }
    }
    
    public void locarVeiculo(VeiculoI veiculo, int dias, Calendar data, Cliente cliente) throws Exception {
        try {
            
            if(!clientesDAO.buscarClientes(cliente.getCpf(), null, null, true).isEmpty()) {
                throw new Exception("Cliente já tem locações ativas.");
            }
            
            veiculo.locar(dias, data, cliente);
            veiculosDAO.atualizarVeiculo(veiculo); 
            veiculosDAO.salvarLocacao(veiculo);
        } catch(SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao salvar locação. Tente novamente.");
        }
    }
    
    public void devolverVeiculo(VeiculoI veiculo) throws Exception {
        try {
            veiculo.devolver();
            veiculosDAO.atualizarVeiculo(veiculo); 
            veiculosDAO.deletarLocacao(veiculo);
        } catch(SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao remover locação. Tente novamente.");
        }
    }
    
    public void venderVeiculo(VeiculoI veiculo) throws Exception {
        try {
            veiculo.vender();
            veiculosDAO.atualizarVeiculo(veiculo); 
        } catch(SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao remover locação. Tente novamente.");
        }
    }
}
