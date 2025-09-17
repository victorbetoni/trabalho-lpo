package com.victorbetoni.alugacar.views;

import com.victorbetoni.alugacar.Alugacar;
import com.victorbetoni.alugacar.enums.Categoria;
import com.victorbetoni.alugacar.enums.Estado;
import com.victorbetoni.alugacar.enums.Marca;
import com.victorbetoni.alugacar.enums.ModeloAutomovel;
import com.victorbetoni.alugacar.enums.ModeloMotocicleta;
import com.victorbetoni.alugacar.enums.ModeloVan;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.Motocicleta;
import com.victorbetoni.alugacar.model.veiculo.Van;
import com.victorbetoni.alugacar.model.veiculo.VeiculoI;
import com.victorbetoni.alugacar.views.tables.TabelaVeiculos;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.JOptionPane;

public class VenderVeiculoView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VenderVeiculoView.class.getName());

    private AtomicReference<VeiculoI> veiculo = new AtomicReference<>();
    
    public VenderVeiculoView() {
        initComponents();
        fieldMarca.removeAllItems();
        fieldMarca.addItem("Todos");
        fieldMarca.setSelectedIndex(0);
        Stream.of(Marca.values()).map(Marca::toString).forEach(fieldMarca::addItem);
        
        fieldModelo.addItem("Todos");
        atualizarModelos();
        atualizarVeiculos();
        
        tblVeiculos.getSelectionModel().addListSelectionListener(tbl -> {
            if(!tbl.getValueIsAdjusting() && tblVeiculos.getSelectedRow() != -1) {
                VeiculoI v = ((TabelaVeiculos) tblVeiculos.getModel()).getVeiculos().get(tblVeiculos.getSelectedRow());
                veiculo.set(v);
            }
        });
    }
    
    public void atualizarModelos() {
       
        fieldModelo.removeAllItems();
        fieldModelo.addItem("Todos");
        boolean qualquerTipo =  fieldTipo.getSelectedIndex() == -1 || fieldTipo.getSelectedItem().toString().equals("Todos");
        boolean qualquerMarca = fieldMarca.getSelectedIndex() == -1 || fieldMarca.getSelectedItem().toString().equals("Todos");
        
        String tipo = fieldTipo.getSelectedItem() != null ? fieldTipo.getSelectedItem().toString() : "";

        if(qualquerMarca) {
            Stream.concat(
                Stream.concat(
                        (qualquerTipo || tipo.equals("Automóvel") ? Stream.of(ModeloAutomovel.values()).map(ModeloAutomovel::toString) : Stream.empty()), 
                        (qualquerTipo || tipo.equals("Motocicleta") ? Stream.of(ModeloMotocicleta.values()).map(ModeloMotocicleta::toString) : Stream.empty())), 
                tipo.equals("Todos") || tipo.equals("Van") ? Stream.of(ModeloVan.values()).map(ModeloVan::toString) : Stream.empty()
            ).forEach(fieldModelo::addItem); 
        } else {
            Marca m = Marca.valueOf(fieldMarca.getSelectedItem().toString());
             Stream.concat(
                Stream.concat(
                        (tipo.equals("Todos") || tipo.equals("Automóvel") ? Stream.of(ModeloAutomovel.values()).filter(x -> x.getMarca() == m).map(ModeloAutomovel::toString) : Stream.empty()), 
                        (tipo.equals("Todos") || tipo.equals("Motocicleta") ? Stream.of(ModeloMotocicleta.values()).filter(x -> x.getMarca() == m).map(ModeloMotocicleta::toString) : Stream.empty())), 
                tipo.equals("Todos") || tipo.equals("Van") ? Stream.of(ModeloVan.values()).filter(x -> x.getMarca() == m).map(ModeloVan::toString) : Stream.empty()
            ).forEach(fieldModelo::addItem); 
        }
    }
    
    public void atualizarVeiculos() {
        tblVeiculos.removeAll();
        String modeloSelecionado = fieldModelo.getSelectedItem().toString();
        
        try {
            List<VeiculoI> veiculos = Alugacar.getGerenciadorVeiculos().buscarVeiculos(
                fieldTipo.getSelectedIndex() == 0 ? -1 : fieldTipo.getSelectedIndex(), 
                fieldMarca.getSelectedIndex() == 0 ? null : Marca.valueOf(fieldMarca.getSelectedItem().toString()),
                null, null, modeloSelecionado.equalsIgnoreCase("Todos") ? null : modeloSelecionado, false, false);
      
            tblVeiculos.setModel(new TabelaVeiculos(veiculos));
        } catch(Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscar = new javax.swing.JButton();
        fieldTipo = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldMarca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        fieldModelo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVeiculos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });

        fieldTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "Motocicleta", "Automóvel", "Van" }));
        fieldTipo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fieldTipoMouseClicked(evt);
            }
        });

        jLabel1.setText("Tipo:");

        jLabel2.setText("Marca:");

        fieldMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fieldMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldMarcaActionPerformed(evt);
            }
        });

        jLabel3.setText("Modelo:");

        fieldModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jButton1.setText("Vender");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Vender veículo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addComponent(jLabel4))
                        .addGap(0, 250, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(fieldTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(fieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(fieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldMarcaActionPerformed
        atualizarModelos();
    }//GEN-LAST:event_fieldMarcaActionPerformed

    private void fieldTipoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fieldTipoMouseClicked
        atualizarModelos();
    }//GEN-LAST:event_fieldTipoMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            if(veiculo.get() == null) {
                JOptionPane.showMessageDialog(null, "Selecione um veiculo", "ERRO", JOptionPane.ERROR);
                return;
            }
            Alugacar.getGerenciadorVeiculos().venderVeiculo(veiculo.get());
            JOptionPane.showMessageDialog(null, "Veículo vendido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            atualizarVeiculos();
        } catch(Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        atualizarVeiculos();
    }//GEN-LAST:event_btnBuscarMouseClicked

    private String extrairModelo(VeiculoI veiculo) {
    if (veiculo instanceof Automovel) {
        return ((Automovel) veiculo).getModelo().getModelo();
    } else if (veiculo instanceof Motocicleta) {
        return ((Motocicleta) veiculo).getModelo().getModelo();
    } else if (veiculo instanceof Van) {
        return ((Van) veiculo).getModelo().getModelo();
    }
    return "";
}
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JComboBox<String> fieldMarca;
    private javax.swing.JComboBox<String> fieldModelo;
    private javax.swing.JComboBox<String> fieldTipo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblVeiculos;
    // End of variables declaration//GEN-END:variables
}
