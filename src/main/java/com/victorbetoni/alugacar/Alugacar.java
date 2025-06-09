/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.victorbetoni.alugacar;

import com.victorbetoni.alugacar.model.Cliente;
import com.victorbetoni.alugacar.views.ClientesView;
import com.victorbetoni.alugacar.views.InicialView;

/**
 *
 * @author VictorHugoBetoni
 */
public class Alugacar {

    private static GerenciadorVeiculos gerenciadorVeiculos;
    private static GerenciadorClientes gerenciadorClientes;
    
    public static void main(String[] args) {
        
        gerenciadorClientes = new GerenciadorClientes();
        gerenciadorVeiculos = new GerenciadorVeiculos();
        
        gerenciadorClientes.adicionarCliente(new Cliente("Victor", "Betoni", "54.670.453-0", "464.612.108-57", "Rua Prof. Dorotea Spak Choma", "Tarumã", "PR", "Curitiba", 241));
        gerenciadorClientes.adicionarCliente(new Cliente("Ana", "Silva", "12.345.678-9", "123.456.789-00", "Av. Paulista", "Bela Vista", "SP", "São Paulo", 1578));
        gerenciadorClientes.adicionarCliente(new Cliente("Lucas", "Ferreira", "98.765.432-1", "987.654.321-11", "Rua das Flores", "Centro", "RJ", "Rio de Janeiro", 320));
        gerenciadorClientes.adicionarCliente(new Cliente("Mariana", "Costa", "23.456.789-0", "234.567.890-22", "Rua do Sol", "Meireles", "CE", "Fortaleza", 876));
        gerenciadorClientes.adicionarCliente(new Cliente("Felipe", "Alves", "67.890.123-4", "678.901.234-33", "Rua das Palmeiras", "Boa Vista", "PE", "Recife", 112));
        gerenciadorClientes.adicionarCliente(new Cliente("Juliana", "Pereira", "45.678.901-2", "456.789.012-44", "Rua Verde", "Savassi", "MG", "Belo Horizonte", 985));
        gerenciadorClientes.adicionarCliente(new Cliente("Rafael", "Mendes", "78.901.234-5", "789.012.345-55", "Rua Nova", "Centro", "RS", "Porto Alegre", 432));
        gerenciadorClientes.adicionarCliente(new Cliente("Isabela", "Oliveira", "56.789.012-3", "567.890.123-66", "Av. Brasil", "Lourdes", "MG", "Belo Horizonte", 654));
        gerenciadorClientes.adicionarCliente(new Cliente("Thiago", "Santos", "89.012.345-6", "890.123.456-77", "Rua das Acácias", "Jardim", "SP", "Campinas", 298));
        gerenciadorClientes.adicionarCliente(new Cliente("Carolina", "Lima", "34.567.890-1", "345.678.901-88", "Rua Central", "Centro", "BA", "Salvador", 765));
        
        java.awt.EventQueue.invokeLater(() -> new InicialView().setVisible(true));
    }

    public static GerenciadorVeiculos getGerenciadorVeiculos() {
        return gerenciadorVeiculos;
    }

    public static GerenciadorClientes getGerenciadorClientes() {
        return gerenciadorClientes;
    }
    
    
    
    
}
