/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.victorbetoni.alugacar;

import com.victorbetoni.alugacar.controller.ClienteController;
import com.victorbetoni.alugacar.controller.VeiculoController;
import com.victorbetoni.alugacar.enums.Categoria;
import com.victorbetoni.alugacar.enums.Estado;
import com.victorbetoni.alugacar.enums.Marca;
import com.victorbetoni.alugacar.enums.ModeloAutomovel;
import com.victorbetoni.alugacar.enums.ModeloMotocicleta;
import com.victorbetoni.alugacar.enums.ModeloVan;
import com.victorbetoni.alugacar.model.Cliente;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.Motocicleta;
import com.victorbetoni.alugacar.model.veiculo.Van;
import com.victorbetoni.alugacar.views.InicialView;
import java.sql.SQLException;

/**
 *
 * @author VictorHugoBetoni
 */
public class Alugacar {

    private static VeiculoController gerenciadorVeiculos;
    private static ClienteController gerenciadorClientes;
    
    public static void main(String[] args) {
        
        gerenciadorClientes = new ClienteController();
        gerenciadorVeiculos = new VeiculoController();
        
        
        try {
            
//            gerenciadorClientes.adicionarCliente(new Cliente("Victor", "Betoni", "54.670.453-0", "464.612.108-57", "Rua Prof. Dorotea Spak Choma", "Tarumã", "PR", "Curitiba", 241));
//            gerenciadorClientes.adicionarCliente(new Cliente("Ana", "Silva", "12.345.678-9", "123.456.789-00", "Av. Paulista", "Bela Vista", "SP", "São Paulo", 1578));
//            gerenciadorClientes.adicionarCliente(new Cliente("Lucas", "Ferreira", "98.765.432-1", "987.654.321-11", "Rua das Flores", "Centro", "RJ", "Rio de Janeiro", 320));
//            gerenciadorClientes.adicionarCliente(new Cliente("Mariana", "Costa", "23.456.789-0", "234.567.890-22", "Rua do Sol", "Meireles", "CE", "Fortaleza", 876));
//            gerenciadorClientes.adicionarCliente(new Cliente("Felipe", "Alves", "67.890.123-4", "678.901.234-33", "Rua das Palmeiras", "Boa Vista", "PE", "Recife", 112));
//            gerenciadorClientes.adicionarCliente(new Cliente("Juliana", "Pereira", "45.678.901-2", "456.789.012-44", "Rua Verde", "Savassi", "MG", "Belo Horizonte", 985));
//            gerenciadorClientes.adicionarCliente(new Cliente("Rafael", "Mendes", "78.901.234-5", "789.012.345-55", "Rua Nova", "Centro", "RS", "Porto Alegre", 432));
//            gerenciadorClientes.adicionarCliente(new Cliente("Isabela", "Oliveira", "56.789.012-3", "567.890.123-66", "Av. Brasil", "Lourdes", "MG", "Belo Horizonte", 654));
//            gerenciadorClientes.adicionarCliente(new Cliente("Thiago", "Santos", "89.012.345-6", "890.123.456-77", "Rua das Acácias", "Jardim", "SP", "Campinas", 298));
//            gerenciadorClientes.adicionarCliente(new Cliente("Carolina", "Lima", "34.567.890-1", "345.678.901-88", "Rua Central", "Centro", "BA", "Salvador", 765));


//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("ABCD-1234", ModeloAutomovel.VW_GOL, Marca.VW, Estado.DISPONIVEL, Categoria.POPULAR, null, 47000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("EFGH-5678", ModeloAutomovel.VW_GOLF, Marca.VW, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 51000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("IJKL-9012", ModeloAutomovel.VW_JETTA, Marca.VW, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 55000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("MNOP-3456", ModeloVan.VW_KOMBI, Marca.VW, Estado.DISPONIVEL, Categoria.POPULAR, null, 82000, 2019));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("QRST-7890", ModeloVan.VW_CRAFTER, Marca.VW, Estado.DISPONIVEL, Categoria.POPULAR, null, 86000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("UVWX-2345", ModeloVan.VW_TRANSPORTER, Marca.VW, Estado.DISPONIVEL, Categoria.POPULAR, null, 90000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("YZAQ-6789", ModeloAutomovel.GM_CELTA, Marca.GM, Estado.DISPONIVEL, Categoria.POPULAR, null, 43000, 2018));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("BCDE-1122", ModeloAutomovel.GM_CRUZE, Marca.GM, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 52000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("FGHI-3344", ModeloAutomovel.GM_ONIX, Marca.GM, Estado.DISPONIVEL, Categoria.POPULAR, null, 50000, 2019));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("JKLM-5566", ModeloVan.GM_SPIN, Marca.GM, Estado.DISPONIVEL, Categoria.POPULAR, null, 87000, 2019));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("NOPQ-7788", ModeloVan.GM_MONTANA_VAN, Marca.GM, Estado.DISPONIVEL, Categoria.POPULAR, null, 89000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("RSTU-9900", ModeloVan.GM_EXpress, Marca.GM, Estado.DISPONIVEL, Categoria.POPULAR, null, 91000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("VWXY-1357", ModeloAutomovel.A200, Marca.MERCEDES, Estado.DISPONIVEL, Categoria.POPULAR, null, 96000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("ZABC-2468", ModeloAutomovel.C200, Marca.MERCEDES, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 104000, 2023));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("DEFG-3691", ModeloAutomovel.AMG_ONE, Marca.MERCEDES, Estado.DISPONIVEL, Categoria.LUXO, null, 920000, 2024));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("HIJK-1470", ModeloAutomovel.BMW_320I, Marca.BMW, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 98000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("LMNO-2581", ModeloAutomovel.M3, Marca.BMW, Estado.DISPONIVEL, Categoria.LUXO, null, 150000, 2023));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("PQRS-3692", ModeloAutomovel.M5, Marca.BMW, Estado.DISPONIVEL, Categoria.LUXO, null, 180000, 2024));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("TUVW-4703", ModeloMotocicleta.BMW_G310R, Marca.BMW, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 44000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("XYZA-5814", ModeloMotocicleta.BMW_S1000RR, Marca.BMW, Estado.DISPONIVEL, Categoria.LUXO, null, 65000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("BCDE-6925", ModeloMotocicleta.BMW_R1250GS, Marca.BMW, Estado.DISPONIVEL, Categoria.LUXO, null, 72000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("FGHI-8036", ModeloAutomovel.C3, Marca.CITROEN, Estado.DISPONIVEL, Categoria.POPULAR, null, 47000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("JKLM-9147", ModeloAutomovel.BASALT, Marca.CITROEN, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 52000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("NOPQ-0258", ModeloAutomovel.C5, Marca.CITROEN, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 60000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("RSTU-1369", ModeloVan.CITROEN_BERLINGO, Marca.CITROEN, Estado.DISPONIVEL, Categoria.POPULAR, null, 87000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("VWXY-2470", ModeloVan.CITROEN_JUMPY, Marca.CITROEN, Estado.DISPONIVEL, Categoria.POPULAR, null, 90000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("ZABC-3581", ModeloVan.CITROEN_JUMPER, Marca.CITROEN, Estado.DISPONIVEL, Categoria.POPULAR, null, 93000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("DUCA-1298", ModeloMotocicleta.DUCATI_MONSTER, Marca.DUCATI, Estado.DISPONIVEL, Categoria.LUXO, null, 62000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("DUCB-2397", ModeloMotocicleta.DUCATI_PANIGALE_V4, Marca.DUCATI, Estado.DISPONIVEL, Categoria.LUXO, null, 78000, 2023));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("DUCC-3840", ModeloMotocicleta.DUCATI_MULTISTRADA, Marca.DUCATI, Estado.DISPONIVEL, Categoria.LUXO, null, 74000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("KAWA-4951", ModeloMotocicleta.KAWASAKI_NINJA400, Marca.KAWASAKI, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 36000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("KAWB-5832", ModeloMotocicleta.KAWASAKI_Z900, Marca.KAWASAKI, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 44000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("KAWC-6129", ModeloMotocicleta.KAWASAKI_VERSYS650, Marca.KAWASAKI, Estado.DISPONIVEL, Categoria.LUXO, null, 40000, 2019));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("SUZA-7024", ModeloMotocicleta.SUZUKI_GSX_S750, Marca.SUZUKI, Estado.DISPONIVEL, Categoria.LUXO, null, 38000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("SUZB-8361", ModeloMotocicleta.SUZUKI_HAYABUSA, Marca.SUZUKI, Estado.DISPONIVEL, Categoria.LUXO, null, 72000, 2023));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("SUZC-9450", ModeloMotocicleta.SUZUKI_VSTROM650, Marca.SUZUKI, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 46000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("YAMA-1786", ModeloMotocicleta.YAMAHA_FAZER250, Marca.YAMAHA, Estado.DISPONIVEL, Categoria.POPULAR, null, 18000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("YAMB-2882", ModeloMotocicleta.YAMAHA_MT07, Marca.YAMAHA, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 31000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("YAMC-3901", ModeloMotocicleta.YAMAHA_R1, Marca.YAMAHA, Estado.DISPONIVEL, Categoria.LUXO, null, 54000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("TOYA-8123", ModeloAutomovel.ETIOS, Marca.TOYOTA, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 48000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("TOYB-9281", ModeloAutomovel.YARIS, Marca.TOYOTA, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 52000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("TOYC-0372", ModeloAutomovel.COROLLA, Marca.TOYOTA, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 58000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("PEUA-1284", ModeloAutomovel.PG_206, Marca.PEUGEOT, Estado.DISPONIVEL, Categoria.POPULAR, null, 41000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("PEUB-2391", ModeloAutomovel.PG_308, Marca.PEUGEOT, Estado.DISPONIVEL, Categoria.POPULAR, null, 48000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("PEUC-3402", ModeloAutomovel.PG_2008, Marca.PEUGEOT, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 53000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("PEUV-4581", ModeloVan.PG_PARTNER, Marca.PEUGEOT, Estado.DISPONIVEL, Categoria.POPULAR, null, 79000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("PEUW-5693", ModeloVan.PG_EXPERT, Marca.PEUGEOT, Estado.DISPONIVEL, Categoria.POPULAR, null, 83000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Van("PEUX-6789", ModeloVan.PG_BOXER, Marca.PEUGEOT, Estado.DISPONIVEL, Categoria.POPULAR, null, 87000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("HONA-7821", ModeloAutomovel.FIT, Marca.HONDA, Estado.DISPONIVEL, Categoria.POPULAR, null, 47000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("HONB-8923", ModeloAutomovel.CIVIC, Marca.HONDA, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 57000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Automovel("HONC-9034", ModeloAutomovel.ACCORD, Marca.HONDA, Estado.DISPONIVEL, Categoria.LUXO, null, 63000, 2022));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("HOND-0145", ModeloMotocicleta.HONDA_CG160, Marca.HONDA, Estado.DISPONIVEL, Categoria.POPULAR, null, 15000, 2020));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("HONE-1256", ModeloMotocicleta.HONDA_CB500F, Marca.HONDA, Estado.DISPONIVEL, Categoria.INTERMEDIARIO, null, 25000, 2021));
//            gerenciadorVeiculos.adicionarVeiculo(new Motocicleta("HONF-2367", ModeloMotocicleta.HONDA_AFRICA_TWIN, Marca.HONDA, Estado.DISPONIVEL, Categoria.LUXO, null, 39000, 2022));
       } catch(Exception ex) {
            ex.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new InicialView().setVisible(true));
        
    }

    public static VeiculoController getGerenciadorVeiculos() {
        return gerenciadorVeiculos;
    }

    public static ClienteController getGerenciadorClientes() {
        return gerenciadorClientes;
    }
    
    
    
    
}
