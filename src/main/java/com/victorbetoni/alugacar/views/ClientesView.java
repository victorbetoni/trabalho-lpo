package com.victorbetoni.alugacar.views;

import com.victorbetoni.alugacar.Alugacar;
import com.victorbetoni.alugacar.Utils;
import com.victorbetoni.alugacar.model.Cliente;
import com.victorbetoni.alugacar.model.Locacao;
import com.victorbetoni.alugacar.views.tables.TabelaClientes;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author VictorHugoBetoni
 */
public class ClientesView extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ClientesView.class.getName());

    private TabelaClientes tabela;
    private Cliente editando;
    private AtomicInteger abaAnterior = new AtomicInteger();

    public ClientesView() {

        initComponents();

        TableColumnModel colMod = tabelaClientes.getColumnModel();
        colMod.getColumn(0).setMinWidth(300);
        colMod.getColumn(1).setMinWidth(150);
        colMod.getColumn(2).setMinWidth(150);
        colMod.getColumn(3).setMinWidth(300);

        MaskFormatter cpfMask = null;
        MaskFormatter rgMask = null;
        try {
            cpfMask = new MaskFormatter("###.###.###-##");
            rgMask = new MaskFormatter("##.###.###-A");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        cpfMask.setPlaceholderCharacter('_');
        fieldCPF.setFormatterFactory(new DefaultFormatterFactory(cpfMask));
        fieldCPF.setColumns(14);
        edicaoCPF.setFormatterFactory(new DefaultFormatterFactory(cpfMask));
        edicaoCPF.setColumns(14);
        
        rgMask.setPlaceholderCharacter('_');
        fieldRG.setFormatterFactory(new DefaultFormatterFactory(rgMask));
        fieldRG.setColumns(12);
        edicaoRG.setFormatterFactory(new DefaultFormatterFactory(rgMask));
        edicaoRG.setColumns(12);
        
        jTabbedPane1.addChangeListener((evento) -> {

            if (jTabbedPane1.getSelectedIndex() == 2 && editando == null) {
                JOptionPane.showMessageDialog(null, "A aba edição não pode ser aberta manualmente. Selecione um cliente na aba LISTAR CLIENTES e clique em EDITAR.", "Aviso!", JOptionPane.WARNING_MESSAGE);
                jTabbedPane1.setSelectedIndex(abaAnterior.get());
            }

            if (jTabbedPane1.getSelectedIndex() != abaAnterior.get() && editando != null && jTabbedPane1.getSelectedIndex() != 2) {
                SwingUtilities.invokeLater(() -> {
                    jTabbedPane1.setSelectedIndex(abaAnterior.get());
                });
            } else {
                abaAnterior.set(jTabbedPane1.getSelectedIndex());
            }
        });

        jTabbedPane1.addChangeListener((e) -> {
            if (jTabbedPane1.getSelectedIndex() == 1) {
                atualizarTabela();
            }
        });

        abaAnterior.set(0);

    }

    public void atualizarTabela() {
        this.tabela = new TabelaClientes(Alugacar.getGerenciadorClientes().getClientes());
        tabelaClientes.setModel(tabela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldSobrenome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldRua = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldBairro = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        fieldNumero = new javax.swing.JTextField();
        fieldEstado = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        fieldCidade = new javax.swing.JTextField();
        btnCadastrarCliente = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        fieldCPF = new javax.swing.JFormattedTextField();
        fieldRG = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        btnExcluirCliente = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        edicaoNome = new javax.swing.JTextField();
        edicaoSobrenome = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        edicaoRua = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        edicaoBairro = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        edicaoNumero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        edicaoEstado = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        edicaoCidade = new javax.swing.JTextField();
        btnSalvarEdicao = new javax.swing.JButton();
        btnCancelarEdicao = new javax.swing.JButton();
        edicaoCPF = new javax.swing.JFormattedTextField();
        edicaoRG = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome");

        jLabel2.setText("Sobrenome");

        jLabel3.setText("CPF");

        jLabel4.setText("RG");

        jLabel5.setText("Rua");

        jLabel6.setText("Bairro");

        jLabel7.setText("Estado");

        jLabel8.setText("Número");

        fieldEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel9.setText("Cidade");

        btnCadastrarCliente.setText("Cadastrar");
        btnCadastrarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCadastrarClienteMouseClicked(evt);
            }
        });

        jButton2.setText("Voltar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCadastrarCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(fieldNome, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3)
                                .addComponent(fieldCPF))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel2)
                                .addComponent(fieldSobrenome, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(fieldRG)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addGap(90, 90, 90)
                            .addComponent(jLabel9))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(fieldRua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(120, 120, 120)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(fieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(fieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(fieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fieldCidade))))
                .addContainerGap(446, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadastrarCliente)
                    .addComponent(jButton2))
                .addContainerGap(132, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Novo Cliente", jPanel1);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(450, 400));

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaClientes);

        btnExcluirCliente.setText("Excluir");
        btnExcluirCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcluirClienteMouseClicked(evt);
            }
        });

        jButton1.setText("Voltar");
        jButton1.setToolTipText("");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnExcluirCliente)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExcluirCliente)
                    .addComponent(jButton1)
                    .addComponent(btnEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Visualizar Clientes", jPanel2);

        jLabel10.setText("Nome");

        jLabel11.setText("Sobrenome");

        jLabel12.setText("CPF");

        jLabel13.setText("RG");

        jLabel14.setText("Rua");

        jLabel15.setText("Bairro");

        jLabel16.setText("Número");

        jLabel17.setText("Estado");

        edicaoEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel18.setText("Cidade");

        btnSalvarEdicao.setText("Salvar");
        btnSalvarEdicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalvarEdicaoMouseClicked(evt);
            }
        });

        btnCancelarEdicao.setText("Cancelar");
        btnCancelarEdicao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarEdicaoMouseClicked(evt);
            }
        });

        edicaoCPF.setEditable(false);

        edicaoRG.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(176, 176, 176)
                            .addComponent(jLabel11))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(edicaoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addComponent(edicaoCPF))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel13)
                                .addComponent(edicaoSobrenome, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                                .addComponent(edicaoRG)))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(edicaoRua, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addGap(93, 93, 93)
                                    .addComponent(jLabel16))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(edicaoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(edicaoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addGap(43, 43, 43)
                            .addComponent(jLabel18))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(edicaoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(edicaoCidade)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnSalvarEdicao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarEdicao)))
                .addContainerGap(454, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edicaoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edicaoSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edicaoCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edicaoRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edicaoRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edicaoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edicaoNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edicaoEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edicaoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvarEdicao)
                    .addComponent(btnCancelarEdicao))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Editar Cliente", jPanel3);

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

    private void btnCadastrarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCadastrarClienteMouseClicked
        String nome = fieldNome.getText();
        String sobrenome = fieldSobrenome.getText();
        String cpf = fieldCPF.getText();
        String rg = fieldRG.getText();
        String rua = fieldRua.getText();
        String bairro = fieldBairro.getText();
        String numero = fieldNumero.getText();
        String estado = fieldEstado.getSelectedItem().toString();
        String cidade = fieldCidade.getText();

        if (!Utils.allFilled(nome, sobrenome, cpf, rg, rua, bairro, numero, estado, cidade)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!Utils.isInteger(numero)) {
            JOptionPane.showMessageDialog(null, "Número do endereço inválido.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cliente cliente = new Cliente(nome, sobrenome, rg, cpf, rua, bairro, estado, cidade, Integer.parseInt(numero));
        Utils.clearTextFields(fieldNome, fieldSobrenome, fieldCPF, fieldRG, fieldRua, fieldBairro, fieldNumero, fieldCidade);
        Alugacar.getGerenciadorClientes().adicionarCliente(cliente);
        JOptionPane.showMessageDialog(null, "Cliente criado com sucesso.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnCadastrarClienteMouseClicked

    private void btnExcluirClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirClienteMouseClicked

        int index = tabelaClientes.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para excluir.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cliente selecionado = tabela.getClientes().get(index);

        List<Locacao> locacoesAtivas = Alugacar.getGerenciadorVeiculos().buscarLocacoes()
                .stream().filter(x -> x.getCliente().getCpf().equalsIgnoreCase(selecionado.getCpf()))
                .collect(Collectors.toList());

        if (!locacoesAtivas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não é permitido excluir clientes com locações ativas.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Alugacar.getGerenciadorClientes().removerClient(selecionado);
        atualizarTabela();
        JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnExcluirClienteMouseClicked

    private void btnEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarMouseClicked
        int index = tabelaClientes.getSelectedRow();

        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Selecione um cliente para editar.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cliente selecionado = tabela.getClientes().get(index);
        editando = selecionado;
        mostrarEdicao();
    }//GEN-LAST:event_btnEditarMouseClicked

    private void btnCancelarEdicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarEdicaoMouseClicked
        editando = null;
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnCancelarEdicaoMouseClicked

    private void btnSalvarEdicaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarEdicaoMouseClicked
        String nome = edicaoNome.getText();
        String sobrenome = edicaoSobrenome.getText();
        String rua = edicaoRua.getText();
        String bairro = edicaoBairro.getText();
        String numero = edicaoNumero.getText();
        String estado = edicaoEstado.getSelectedItem().toString();
        String cidade = edicaoCidade.getText();

        if (!Utils.allFilled(nome, sobrenome, rua, bairro, numero, estado, cidade)) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (!Utils.isInteger(numero)) {
            JOptionPane.showMessageDialog(null, "Número do endereço inválido.", "Aviso!", JOptionPane.WARNING_MESSAGE);
            return;
        }

        editando.setNome(nome);
        editando.setSobrenome(sobrenome);
        editando.setRua(rua);
        editando.setBairro(bairro);
        editando.setNumero(Integer.parseInt(numero));
        editando.setEstado(estado);
        editando.setCidade(cidade);

        JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso.", "Sucesso!", JOptionPane.INFORMATION_MESSAGE);
        Utils.clearTextFields(edicaoBairro, edicaoCPF, edicaoRG, edicaoCidade, edicaoNome, edicaoRua, edicaoNumero, edicaoSobrenome);
        editando = null;
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_btnSalvarEdicaoMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.dispose();
    }//GEN-LAST:event_jButton2MouseClicked

    private void mostrarEdicao() {
        edicaoBairro.setText(editando.getBairro());
        edicaoCPF.setText(editando.getCpf());
        edicaoCidade.setText(editando.getCidade());
        edicaoEstado.setSelectedItem(editando.getEstado());
        edicaoNome.setText(editando.getNome());
        edicaoNumero.setText(editando.getNumero() + "");
        edicaoRua.setText(editando.getRua());
        edicaoSobrenome.setText(editando.getSobrenome());
        edicaoRG.setText(editando.getRg());
        jTabbedPane1.setSelectedIndex(2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarCliente;
    private javax.swing.JButton btnCancelarEdicao;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluirCliente;
    private javax.swing.JButton btnSalvarEdicao;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField edicaoBairro;
    private javax.swing.JFormattedTextField edicaoCPF;
    private javax.swing.JTextField edicaoCidade;
    private javax.swing.JComboBox<String> edicaoEstado;
    private javax.swing.JTextField edicaoNome;
    private javax.swing.JTextField edicaoNumero;
    private javax.swing.JFormattedTextField edicaoRG;
    private javax.swing.JTextField edicaoRua;
    private javax.swing.JTextField edicaoSobrenome;
    private javax.swing.JTextField fieldBairro;
    private javax.swing.JFormattedTextField fieldCPF;
    private javax.swing.JTextField fieldCidade;
    private javax.swing.JComboBox<String> fieldEstado;
    private javax.swing.JTextField fieldNome;
    private javax.swing.JTextField fieldNumero;
    private javax.swing.JFormattedTextField fieldRG;
    private javax.swing.JTextField fieldRua;
    private javax.swing.JTextField fieldSobrenome;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaClientes;
    // End of variables declaration//GEN-END:variables
}
