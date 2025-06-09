/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.victorbetoni.alugacar;

import com.victorbetoni.alugacar.model.Cliente;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.VeiculoI;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author VictorHugoBetoni
 */
public class GerenciadorClientes {
    
    private List<Cliente> clientes = new ArrayList();

    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }
    
    public void removerClient(Cliente cliente) {
        this.clientes.remove(cliente);
    }
    
}
