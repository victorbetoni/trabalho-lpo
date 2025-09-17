/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar.dao;

import com.victorbetoni.alugacar.database.Database;
import com.victorbetoni.alugacar.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VictorHugoBetoni
 */
public class ClienteDAO {
    
    public List<Cliente> buscarClientes(String cpfF, String nomeF, String sobrenomeF, Boolean locacoes) throws SQLException {
        
        String sql = "SELECT Clientes.cpf, Clientes.rg, Clientes.nome, Clientes.sobrenome, Clientes.rua, Clientes.bairro," +
                "   Clientes.estado, Clientes.cidade, Clientes.numero, Locacoes.dias, Locacoes.valor, Locacoes.data, Locacoes.id FROM Clientes" +
                "   LEFT JOIN Locacoes ON Locacoes.cpf = Clientes.cpf" +
                "   LEFT JOIN Veiculos ON Veiculos.placa = Locacoes.placa AND Veiculos.estado = 'LOCADO'" +
                "   WHERE (? IS NULL OR REPLACE(REPLACE(Clientes.cpf, '-', ''), '.', '') LIKE ?)" +
                "   AND (? IS NULL OR LOWER(nome) LIKE ?)" +
                "   AND (? IS NULL OR LOWER(sobrenome) LIKE ?)";
        
        if(locacoes != null) {
            if(locacoes) {
                sql += "    AND Veiculos.placa IS NOT NULL";
            } else {
                sql += "    AND Veiculos.placa IS NULL";
            }
        }

        try(Connection conn = Database.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cpfF);
            st.setString(2, cpfF == null? null : "%" + cpfF.replaceAll("[-.]", "") + "%");
            st.setString(3, nomeF);
            st.setString(4, nomeF == null ? null : "%" + nomeF.toLowerCase() + "%");
            st.setString(5, sobrenomeF);
            st.setString(6, sobrenomeF == null ? null : "%" + sobrenomeF.toLowerCase() + "%");
            
            ResultSet rs = st.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
            
            while(rs.next()) {
                
                String cpf       = rs.getString("cpf");
                String rg        = rs.getString("rg");
                String nome      = rs.getString("nome");
                String sobrenome = rs.getString("sobrenome");
                String rua       = rs.getString("rua");
                String bairro    = rs.getString("bairro");
                String estado    = rs.getString("estado");
                String cidade    = rs.getString("cidade");
                int numero       = rs.getInt("numero");

                clientes.add(new Cliente(nome, sobrenome, rg, cpf, rua, bairro, estado, cidade, numero));
            }
            
            return clientes;
        }
        
    }
    
    public void adicionarCliente(Cliente cliente) throws SQLException {
        
        String sql = "INSERT INTO Clientes (cpf, nome, sobrenome, rg, rua, bairro, estado, cidade, numero) VALUES (?,?,?,?,?,?,?,?,?)";
        
        try(Connection conn = Database.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cliente.getCpf());
            st.setString(2, cliente.getNome());
            st.setString(3, cliente.getSobrenome());
            st.setString(4, cliente.getRg());
            st.setString(5, cliente.getRua());
            st.setString(6, cliente.getBairro());
            st.setString(7, cliente.getEstado());
            st.setString(8, cliente.getCidade());
            st.setInt(9, cliente.getNumero());
            st.executeUpdate();
        }
        
    }
    
    public void removerClient(Cliente cliente) throws SQLException {
        
        String sql = "DELETE FROM Clientes WHERE cpf = ?";
        
        try(Connection conn = Database.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cliente.getCpf());
            st.executeUpdate();
        }
        
    }
    
    public void atualizarCliente(Cliente cliente) throws SQLException {
        String sql = "UPDATE Clientes SET nome = ?, sobrenome = ?, rua = ?, bairro = ?, estado = ?, cidade = ?, numero = ? WHERE cpf = ?";
        
        try(Connection conn = Database.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getSobrenome());
            st.setString(3, cliente.getRua());
            st.setString(4, cliente.getBairro());
            st.setString(5, cliente.getEstado());
            st.setString(6, cliente.getCidade());
            st.setInt(7, cliente.getNumero());
            st.setString(8, cliente.getCpf());
            st.executeUpdate();
        }
    }
    
}
