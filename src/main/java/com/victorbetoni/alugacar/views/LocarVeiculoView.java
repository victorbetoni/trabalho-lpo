package com.victorbetoni.alugacar.views;

import java.util.List;
import com.victorbetoni.alugacar.Alugacar;
import com.victorbetoni.alugacar.Utils;
import com.victorbetoni.alugacar.enums.Categoria;
import com.victorbetoni.alugacar.enums.Estado;
import com.victorbetoni.alugacar.enums.Marca;
import com.victorbetoni.alugacar.model.Cliente;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.Motocicleta;
import com.victorbetoni.alugacar.model.veiculo.Van;
import com.victorbetoni.alugacar.model.veiculo.VeiculoI;
import com.victorbetoni.alugacar.views.tables.TabelaClientes;
import com.victorbetoni.alugacar.views.tables.TabelaVeiculos;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;
import javax.swing.JFormattedTextField;
import javax.swing.ListSelectionModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 * @author VictorHugoBetoni
 */
public class LocarVeiculoView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(LocarVeiculoView.class.getName());
    private NumberFormat moedaFormat;
    private NumberFormatter moedaFormatter;
    private AtomicReference<VeiculoI> veiculo = new AtomicReference<>();
    private AtomicReference<Cliente> cliente = new AtomicReference<>();
    
    public LocarVeiculoView() {
        initComponents();
        cboMarca.addItem("Todos");
        fieldDiasLocados.setText("1");
        Stream.of(Marca.values()).map(Marca::getNome).forEach(cboMarca::addItem);
        
        atualizarVeiculos();
        atualizarClientes();
        
        tblVeiculos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        fieldDataLocacao.setColumns(10);

        try {
            fieldDataLocacao.setColumns(10);
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            DateFormatter dateFormatter = new DateFormatter(df);
            fieldDataLocacao.setFormatterFactory(new DefaultFormatterFactory(dateFormatter));
            fieldDataLocacao.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        tblVeiculos.getSelectionModel().addListSelectionListener(tbl -> {
            if(!tbl.getValueIsAdjusting() && tblVeiculos.getSelectedRow() != -1) {
                System.out.println("Passou");
                VeiculoI v = ((TabelaVeiculos) tblVeiculos.getModel()).getVeiculos().get(tblVeiculos.getSelectedRow());
                veiculo.set(v);
                this.lblPrecoDiaria.setText("Total: " + Utils.formatarMoeda(v.getValorDiariaLocacao()));
                if(Utils.allFilled(fieldDiasLocados.getText())) {
                    int dias = Integer.parseInt(fieldDiasLocados.getText());
                    this.lblTotal.setText(String.format("Total: %s", Utils.formatarMoeda(dias*veiculo.get().getValorDiariaLocacao())));
                    this.lblTotal.updateUI();
                }
            }
        });
        
        tblClientes.getSelectionModel().addListSelectionListener(tbl -> {
            if(!tbl.getValueIsAdjusting() && tblClientes.getSelectedRow() != -1) {
                Cliente c = ((TabelaClientes) tblClientes.getModel()).getClientes().get(tblClientes.getSelectedRow());
                cliente.set(c);
            }
        });
        
    }
    
    public void atualizarVeiculos() {
        tblVeiculos.removeAll();
        List<VeiculoI> veiculos = Alugacar.getGerenciadorVeiculos().getVeiculos().stream()
                .filter(x -> {
                    if(cboTipo.getSelectedIndex() == 0) {
                        return true;
                    }
                    String selectedItem = cboTipo.getSelectedItem().toString();
                    if(selectedItem.equalsIgnoreCase("Automóvel")) {
                        return x instanceof Automovel;
                    }
                    if(selectedItem.equalsIgnoreCase("Van")) {
                        return x instanceof Van;
                    }
                    return x instanceof Motocicleta;
                })
                .filter(x -> cboCategoria.getSelectedIndex() == 0 || x.getCategoria() == Categoria.getByName(cboCategoria.getSelectedItem().toString()))
                .filter(x -> cboMarca.getSelectedIndex() == 0 || x.getMarca() == Marca.getByName(cboMarca.getSelectedItem().toString()))
                .filter(x -> x.getEstado() == Estado.DISPONIVEL || x.getEstado() == Estado.NOVO)
                .toList();
        
        tblVeiculos.setModel(new TabelaVeiculos(veiculos));
    }
    
    public void atualizarClientes() {
        tblClientes.removeAll();
        List<Cliente> clientes = Alugacar.getGerenciadorClientes().getClientes().stream()
                .filter(x -> x.getCpf().replaceAll("[^a-zA-Z0-9]", "").contains(filtroCPF.getText().replaceAll("[^a-zA-Z0-9]", "")))
                .filter(x -> x.getNome().contains(filtroNome.getText()))
                .filter(x -> x.getSobrenome().contains(filtroSobrenome.getText()))
                .toList();
        tblClientes.setModel(new TabelaClientes(clientes));
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cboMarca = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox<>();
        btnBuscarVeiculo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        filtroNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        filtroSobrenome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        filtroCPF = new javax.swing.JTextField();
        btnBuscarCliente = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        lblPrecoDiaria = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        fieldDataLocacao = new javax.swing.JFormattedTextField();
        fieldDiasLocados = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblVeiculos);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Filtrar veículo");

        jLabel2.setText("Tipo:");

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Automóvel", "Motocicleta", "Van" }));

        jLabel3.setText("Marca:");

        jLabel4.setText("Categoria");

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Popular", "Intermediário", "Luxo" }));

        btnBuscarVeiculo.setText("Buscar");
        btnBuscarVeiculo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarVeiculoMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Filtrar cliente");

        jLabel6.setText("Nome:");

        jLabel7.setText("Sobrenome:");

        jLabel8.setText("CPF:");

        btnBuscarCliente.setText("Buscar");
        btnBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarClienteMouseClicked(evt);
            }
        });

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblClientes);

        lblPrecoDiaria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPrecoDiaria.setText("Preço diária:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setText("Total:");

        jLabel9.setText("Data de locação");

        jButton1.setText("Locar");

        jButton2.setText("Voltar");

        jLabel10.setText("Dias locados");

        fieldDiasLocados.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        fieldDiasLocados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldDiasLocadosKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblPrecoDiaria))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(312, 312, 312)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtroNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtroSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filtroCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscarCliente))
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(lblTotal)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                                            .addComponent(fieldDataLocacao))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(fieldDiasLocados, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(filtroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(filtroSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(filtroCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarVeiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldDataLocacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldDiasLocados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblPrecoDiaria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarVeiculoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarVeiculoMouseClicked
        atualizarVeiculos();
    }//GEN-LAST:event_btnBuscarVeiculoMouseClicked

    private void btnBuscarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarClienteMouseClicked
        atualizarClientes();
    }//GEN-LAST:event_btnBuscarClienteMouseClicked

    private void fieldDiasLocadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldDiasLocadosKeyTyped
        int diasLocados = 0;
        try {
            diasLocados = Integer.parseInt(fieldDiasLocados.getText());
        } catch (Exception ex) {
            fieldDiasLocados.setText(fieldDiasLocados.getText().replaceAll("[^0-9]", ""));
        }
        if(veiculo.get() != null) {
            this.lblTotal.setText(String.format("Total: %s", Utils.formatarMoeda(diasLocados*veiculo.get().getValorDiariaLocacao())));
            this.lblTotal.updateUI();
        }
    }//GEN-LAST:event_fieldDiasLocadosKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarCliente;
    private javax.swing.JButton btnBuscarVeiculo;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cboMarca;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JFormattedTextField fieldDataLocacao;
    private javax.swing.JFormattedTextField fieldDiasLocados;
    private javax.swing.JTextField filtroCPF;
    private javax.swing.JTextField filtroNome;
    private javax.swing.JTextField filtroSobrenome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPrecoDiaria;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTable tblVeiculos;
    // End of variables declaration//GEN-END:variables
}
