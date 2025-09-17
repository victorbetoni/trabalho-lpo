package com.victorbetoni.alugacar.dao;

import com.victorbetoni.alugacar.database.Database;
import com.victorbetoni.alugacar.enums.Categoria;
import com.victorbetoni.alugacar.enums.Estado;
import com.victorbetoni.alugacar.enums.Marca;
import com.victorbetoni.alugacar.enums.ModeloAutomovel;
import com.victorbetoni.alugacar.enums.ModeloMotocicleta;
import com.victorbetoni.alugacar.enums.ModeloVan;
import com.victorbetoni.alugacar.model.Cliente;
import com.victorbetoni.alugacar.model.Locacao;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.Motocicleta;
import com.victorbetoni.alugacar.model.veiculo.Van;
import com.victorbetoni.alugacar.model.veiculo.VeiculoI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class VeiculoDAO {
    
    public List<VeiculoI> buscarVeiculos(int tipo, Marca marca, Categoria categoria, String placa, String modelo, Boolean locado, Boolean vendido) throws SQLException {
        try(Connection conn = Database.getConnection()) {
            String sql =
                "SELECT " +
                "    tipo, Veiculos.placa, marca, modelo, Veiculos.estado, categoria, valor_compra, ano, " +
                "    Locacoes.valor AS locacao_valor, Locacoes.dias, Locacoes.data, " +
                "    Clientes.nome, Clientes.sobrenome, Clientes.rg, Clientes.cpf, " +
                "    Clientes.rua, Clientes.bairro, Clientes.cidade, Clientes.estado AS cliente_estado, Clientes.numero " +
                "FROM Veiculos " +
                "LEFT JOIN Locacoes ON Locacoes.placa = Veiculos.placa " +
                "LEFT JOIN Clientes ON Locacoes.cpf = Clientes.cpf " +
                "WHERE " +
                "    (? = -1 OR tipo = ?) " +
                "    AND (? IS NULL OR marca = ?) " +
                "    AND (? IS NULL OR categoria = ?)" +
                "    AND (? IS NULL OR Veiculos.placa = ?)" + 
                "    AND (? IS NULL OR modelo = ?)";
            
            if(locado != null) {
                if(locado) {
                    sql += " AND (Locacoes.valor IS NOT NULL)";
                } else {
                    sql += " AND (Locacoes.valor IS NULL)";
                }
            }
            
            if(vendido != null) {
                if(vendido) {
                    sql += " AND (Veiculos.estado = 'VENDIDO')";
                } else {
                    sql += " AND (Veiculos.estado != 'VENDIDO')";
                }
            }
            
            try(PreparedStatement st = conn.prepareStatement(sql)) {
                st.setInt(1, tipo);
                st.setInt(2, tipo);
                st.setString(3, marca == null ? null : marca.toString());
                st.setString(4, marca == null ? null : marca.toString());
                st.setString(5, categoria == null ? null : categoria.toString());
                st.setString(6, categoria == null ? null : categoria.toString());
                st.setString(7, placa);
                st.setString(8, placa);
                st.setString(9, modelo);
                st.setString(10, modelo);
                
                System.out.println("SQL executado: " + st.toString());
                
                List<VeiculoI> result = new ArrayList<>();
                ResultSet rs = st.executeQuery();
                while(rs.next()) {
                    int tp = rs.getInt("tipo");
                    String placaV = rs.getString("placa");
                    String mod = rs.getString("modelo");
                    String m = rs.getString("marca");
                    String e = rs.getString("estado");
                    String c = rs.getString("categoria");
                    double valorCompra = rs.getDouble("valor_compra");
                    int ano = rs.getInt("ano");
                    
                    double locacaoValor = rs.getInt("locacao_valor");
                    Locacao loc = null;
                    
                    if(!rs.wasNull()) {
                        String clienteNome = rs.getString("nome");
                        String clienteSobrenome = rs.getString("sobrenome");
                        String clienteRg = rs.getString("rg");
                        String clienteCpf = rs.getString("cpf");
                        String clienteRua = rs.getString("rua");
                        String clienteBairro = rs.getString("bairro");
                        String clienteEstado = rs.getString("cliente_estado");
                        String clienteCidade = rs.getString("cidade");
                        int clienteNumero = rs.getInt("numero");
        
                        int locacaoDias = rs.getInt("dias");
                        long locacaoData = rs.getLong("data");
                        Date date = new Date(locacaoData);
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        Cliente cliente = new Cliente(clienteNome, clienteSobrenome, clienteRg, clienteCpf, clienteRua, clienteBairro, clienteEstado, clienteCidade, clienteNumero); 
                        loc = new Locacao(locacaoDias, locacaoValor, calendar, cliente);
                    }
                    switch(rs.getInt("tipo")) {
                        case 1:
                            result.add(new Motocicleta(placaV, ModeloMotocicleta.valueOf(mod), Marca.valueOf(m), Estado.valueOf(e), Categoria.valueOf(c), loc, valorCompra, ano));
                            break;
                        case 2:
                            result.add(new Automovel(placaV, ModeloAutomovel.valueOf(mod), Marca.valueOf(m), Estado.valueOf(e), Categoria.valueOf(c), loc, valorCompra, ano));
                            break;
                        case 3:
                            result.add(new Van(placaV, ModeloVan.valueOf(mod), Marca.valueOf(m), Estado.valueOf(e), Categoria.valueOf(c), loc, valorCompra, ano));
                            break;
                    }
                }
                return result;
            }
        }
    }
    
    public void salvarVeiculo(VeiculoI veiculo) throws SQLException {
        try(Connection conn = Database.getConnection()) {
            String sql = "INSERT INTO Veiculos (tipo, placa, marca, estado, categoria, valor_compra, ano, modelo) VALUES (?,?,?,?,?,?,?,?);";
            try(PreparedStatement st = conn.prepareStatement(sql)) {
                int tipo;
                String modelo;
                if(veiculo instanceof Motocicleta) {
                    tipo = 1;
                    modelo = ((Motocicleta)veiculo).getModelo().toString();
                } else if (veiculo instanceof Automovel) {
                    tipo = 2;
                    modelo = ((Automovel)veiculo).getModelo().toString();
                } else {
                    tipo = 3;
                    modelo = ((Van)veiculo).getModelo().toString();
                }
                st.setInt(1, tipo);
                st.setString(2, veiculo.getPlaca());
                st.setString(3, veiculo.getMarca().toString());
                st.setString(4, veiculo.getEstado().toString());
                st.setString(5, veiculo.getCategoria().toString());
                st.setDouble(6, veiculo.getValorParaVenda());
                st.setInt(7, veiculo.getAno());
                st.setString(8, modelo);
                st.executeUpdate();
            }
        }
    }
    
    public void atualizarVeiculo(VeiculoI veiculo) throws SQLException {
        
        String sql = "UPDATE Veiculos SET marca=?,estado=?,categoria=?,valor_compra=?,ano=?,modelo=? WHERE placa=?";
        
        String modelo = veiculo instanceof Motocicleta ? ((Motocicleta)veiculo).getModelo().toString()
                : veiculo instanceof Automovel ? ((Automovel)veiculo).getModelo().toString() : ((Van)veiculo).getModelo().toString();
        
        try(Connection conn = Database.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, veiculo.getMarca().toString());
            st.setString(2, veiculo.getEstado().toString());
            st.setString(3, veiculo.getCategoria().toString());
            st.setDouble(4, veiculo.getValorParaVenda());
            st.setInt(5, veiculo.getAno());
            st.setString(6, modelo);
            st.setString(7, veiculo.getPlaca());
            st.executeUpdate();
        }
        
    }
    
    public void salvarLocacao(VeiculoI veiculo) throws SQLException {
        
        String sql = "INSERT INTO Locacoes (dias, valor, data, cpf, placa) VALUES (?,?,?,?,?)";
        
        try(Connection conn = Database.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setInt(1, veiculo.getLocacao().getDias());
            st.setDouble(2, veiculo.getLocacao().getValor());
            st.setLong(3, veiculo.getLocacao().getData().getTimeInMillis());
            st.setString(4, veiculo.getLocacao().getCliente().getCpf());
            st.setString(5, veiculo.getPlaca());
            st.executeUpdate();
        }
        
    }
    
    public void deletarLocacao(VeiculoI veiculo) throws SQLException {
        
        String sql = "DELETE FROM Locacoes WHERE placa = ?";
        try(Connection conn = Database.getConnection(); PreparedStatement st = conn.prepareStatement(sql)) {
            st.setString(1, veiculo.getPlaca());
            st.executeUpdate();
        }
        
    }
    
}
