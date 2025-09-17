/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.controller;

import com.victorbetoni.alugacar.dao.ClienteDAO;
import com.victorbetoni.alugacar.model.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VictorHugoBetoni
 */
public class ClienteController {
    
    private ClienteDAO clientesDAO = new ClienteDAO();

    public List<Cliente> buscarClientes(String cpf, String nome, String sobrenome, Boolean locacoes) throws Exception {
        try {
            return clientesDAO.buscarClientes(cpf, nome, sobrenome, locacoes);
        } catch(SQLException ex) {
             ex.printStackTrace();
            throw new Exception("Erro ao buscar clientes. Tente novamente.");
        }
    }
    
    public void adicionarCliente(Cliente cliente) throws Exception {
        try {
            clientesDAO.adicionarCliente(cliente);
        } catch(SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Erro ao adicionar cliente. Tente novamente.");
        }
    }
    
    public void removerCliente(Cliente cliente) throws Exception {
        try {
            clientesDAO.removerClient(cliente);
        } catch(SQLException ex) {
             ex.printStackTrace();
            throw new Exception("Erro ao excluir cliente. Tente novamente.");
        }
    }
    
    public void atualizarCliente(Cliente cliente) throws Exception {
        try {
            clientesDAO.atualizarCliente(cliente);
        } catch(SQLException ex) {
             ex.printStackTrace();
            throw new Exception("Erro ao atualizar cliente. Tente novamente.");
        }
    }
    
}
