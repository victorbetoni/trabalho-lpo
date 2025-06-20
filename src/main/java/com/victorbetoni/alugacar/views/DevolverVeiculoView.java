/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.victorbetoni.alugacar.views;

import com.victorbetoni.alugacar.Alugacar;
import com.victorbetoni.alugacar.Utils;
import com.victorbetoni.alugacar.enums.Categoria;
import com.victorbetoni.alugacar.enums.Estado;
import com.victorbetoni.alugacar.enums.Marca;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.Motocicleta;
import com.victorbetoni.alugacar.model.veiculo.Van;
import com.victorbetoni.alugacar.model.veiculo.VeiculoI;
import com.victorbetoni.alugacar.views.tables.TabelaVeiculoLocado;
import com.victorbetoni.alugacar.views.tables.TabelaVeiculos;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author VictorHugoBetoni
 */
public class DevolverVeiculoView extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(DevolverVeiculoView.class.getName());

    private AtomicReference<VeiculoI> veiculo = new AtomicReference<>();
    
    public DevolverVeiculoView() {
        initComponents();
        atualizarLocacoes();
        tblLocacoes.getSelectionModel().addListSelectionListener(tbl -> {
            if(!tbl.getValueIsAdjusting() && tblLocacoes.getSelectedRow() != -1) {
                VeiculoI v = ((TabelaVeiculoLocado) tblLocacoes.getModel()).getVeiculos().get(tblLocacoes.getSelectedRow());
                veiculo.set(v);
            }
        });
    }
    
    public void atualizarLocacoes() {
        tblLocacoes.removeAll();
        List<VeiculoI> veiculos = Alugacar.getGerenciadorVeiculos().getVeiculos().stream()
                .filter(x -> x.getEstado() == Estado.LOCADO)
                .collect(Collectors.toList());
        
        tblLocacoes.setModel(new TabelaVeiculoLocado(veiculos));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLocacoes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Veículos locados:");

        jButton1.setText("Devolver veículo");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        tblLocacoes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblLocacoes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        if(veiculo.get() == null) {
            JOptionPane.showMessageDialog(null, "Selecione uma locação", "ERRO", JOptionPane.ERROR);
            return;
        }
        veiculo.get().devolver();
        JOptionPane.showMessageDialog(null, "Veículo devolvido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        atualizarLocacoes();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblLocacoes;
    // End of variables declaration//GEN-END:variables
}
