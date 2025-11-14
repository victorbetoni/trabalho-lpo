package com.victorbetoni.alugacar.views;

import com.victorbetoni.alugacar.Alugacar;
import com.victorbetoni.alugacar.Utils;
import com.victorbetoni.alugacar.enums.Categoria;
import com.victorbetoni.alugacar.enums.Estado;
import com.victorbetoni.alugacar.enums.Marca;
import com.victorbetoni.alugacar.enums.ModeloAutomovel;
import com.victorbetoni.alugacar.enums.ModeloMotocicleta;
import com.victorbetoni.alugacar.enums.ModeloVan;
import com.victorbetoni.alugacar.model.veiculo.Automovel;
import com.victorbetoni.alugacar.model.veiculo.Motocicleta;
import com.victorbetoni.alugacar.model.veiculo.Van;
import com.victorbetoni.alugacar.model.veiculo.Veiculo;
import java.sql.SQLException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author VictorHugoBetoni
 */
public class VeiculosView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VeiculosView.class.getName());

    public VeiculosView() {
        initComponents();
        cboMarca.setEditable(false);
        cboModelo.setEditable(false);

        atualizarMarcas();
        atualizarModelos();
        
        fieldValorCompra.setFormatterFactory(new DefaultFormatterFactory(Utils.MOEDA_FORMATTER));
        fieldValorCompra.setValue(0.0);
        fieldValorCompra.setColumns(15);
        fieldValorCompra.revalidate();
        fieldValorCompra.repaint();

        MaskFormatter placaMask = null;
        try {
            placaMask = new MaskFormatter("UUUU-####");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        placaMask.setPlaceholderCharacter('_');
        fieldPlaca.setFormatterFactory(new DefaultFormatterFactory(placaMask));
        fieldPlaca.setColumns(14);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cboTipo = new javax.swing.JComboBox<>();
        cboMarca = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboModelo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cboCategoria = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cboAno = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        fieldValorCompra = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        fieldPlaca = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo");

        cboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automóvel", "Motocicleta", "Van" }));
        cboTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTipoActionPerformed(evt);
            }
        });

        cboMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMarcaActionPerformed(evt);
            }
        });

        jLabel2.setText("Marca");

        jLabel3.setText("Modelo");

        jLabel4.setText("Categoria");

        cboCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Popular", "Intermediário", "Luxo" }));

        jLabel5.setText("Ano");

        cboAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980" }));

        jLabel6.setText("Valor de compra");

        jLabel7.setText("Placa");

        jButton1.setText("Voltar");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(cboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addComponent(fieldPlaca))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap(464, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cboMarca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCadastrar))
                .addContainerGap(209, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Novo Veículo", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTipoActionPerformed
        atualizarMarcas();
    }//GEN-LAST:event_cboTipoActionPerformed

    private void cboMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMarcaActionPerformed
        atualizarModelos();
    }//GEN-LAST:event_cboMarcaActionPerformed

    private void btnCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarMouseClicked
        
        String tipo = cboTipo.getSelectedItem().toString();
        String marca = cboMarca.getSelectedItem().toString();
        String modelo = cboModelo.getSelectedItem().toString();
        String categoria = cboCategoria.getSelectedItem().toString();
        String valorCompra = fieldValorCompra.getText();
        String placa = fieldPlaca.getText();
        String ano = cboAno.getSelectedItem().toString();
        
        if(!Utils.allFilled(tipo, marca, modelo, categoria, valorCompra, placa, ano)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            
            Marca marcaM = Marca.getByName(marca);
            Categoria cat = Categoria.getByName(categoria);

            Number numero;
            try {
                numero = Utils.MOEDA_FORMAT.parse(valorCompra);
            } catch(ParseException ex) {
                JOptionPane.showMessageDialog(null, "Valor de compra inválido.", "Aviso!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double valor = numero.doubleValue();

            int anoI = Integer.parseInt(ano);

            Veiculo veiculo = null;

            switch(tipo) {
                case "Automóvel":
                    veiculo = new Automovel(placa, ModeloAutomovel.getByName(modelo), marcaM, Estado.NOVO, cat, null, valor, anoI);
                    break;
                case "Motocicleta":
                    veiculo = new Motocicleta(placa, ModeloMotocicleta.getByName(modelo), marcaM, Estado.NOVO, cat, null, valor, anoI);
                    break;
                case "Van":
                    veiculo = new Van(placa, ModeloVan.getByName(modelo), marcaM, Estado.NOVO, cat, null, valor, anoI);
                    break;
            }

            if (veiculo == null) {
                JOptionPane.showMessageDialog(null, "Algo deu errado. Tente novamente mais tarde.", "Aviso!", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Alugacar.getGerenciadorVeiculos().adicionarVeiculo(veiculo);
            JOptionPane.showMessageDialog(null, "Veículo cadastrado com sucesso.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
            fieldValorCompra.setText("");
            fieldPlaca.setText("");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCadastrarMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void atualizarMarcas() {
        cboMarca.removeAllItems();

        switch (cboTipo.getSelectedItem().toString()) {
            case "Automóvel":
                Stream.of(ModeloAutomovel.values()).map(x -> x.getMarca().getNome()).collect(Collectors.toSet()).forEach(cboMarca::addItem);
                break;
            case "Motocicleta":
                Stream.of(ModeloMotocicleta.values()).map(x -> x.getMarca().getNome()).collect(Collectors.toSet()).forEach(cboMarca::addItem);
                break;
            case "Van":
                Stream.of(ModeloVan.values()).map(x -> x.getMarca().getNome()).collect(Collectors.toSet()).forEach(cboMarca::addItem);
                break;
        }

        cboMarca.setEditable(true);
    }

    private void atualizarModelos() {
        cboModelo.removeAllItems();
        
        if(cboMarca.getSelectedItem() == null) {
            return;
        }

        Marca m = Marca.getByName(cboMarca.getSelectedItem().toString());

        switch (cboTipo.getSelectedItem().toString()) {
            case "Automóvel":
                Stream.of(ModeloAutomovel.values()).filter(x -> x.getMarca() == m).map(x -> x.getModelo()).collect(Collectors.toSet()).forEach(cboModelo::addItem);
                break;
            case "Motocicleta":
                Stream.of(ModeloMotocicleta.values()).filter(x -> x.getMarca() == m).map(x -> x.getModelo()).collect(Collectors.toSet()).forEach(cboModelo::addItem);
                break;
            case "Van":
                Stream.of(ModeloVan.values()).filter(x -> x.getMarca() == m).map(x -> x.getModelo()).collect(Collectors.toSet()).forEach(cboModelo::addItem);
                break;
        }

        cboModelo.setEditable(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JComboBox<String> cboAno;
    private javax.swing.JComboBox<String> cboCategoria;
    private javax.swing.JComboBox<String> cboMarca;
    private javax.swing.JComboBox<String> cboModelo;
    private javax.swing.JComboBox<String> cboTipo;
    private javax.swing.JFormattedTextField fieldPlaca;
    private javax.swing.JFormattedTextField fieldValorCompra;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
