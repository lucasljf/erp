/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.util.Collections;
import javax.swing.AbstractButton;
import controlador.SaidaController;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Batman
 */
public class BuscarSaida extends javax.swing.JFrame {

    /**
     * Creates new form BuscarSaida
     */
    public BuscarSaida() {
        initComponents();
        desativarTudo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filtrosGroup = new javax.swing.ButtonGroup();
        tiposGroup = new javax.swing.ButtonGroup();
        dataInicioSaidaTextField = new javax.swing.JTextField();
        dataFinalSaidaTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        buscarSaidaBotao = new javax.swing.JButton();
        nomeProdutoTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        produtoSaidaRadioBotao = new javax.swing.JRadioButton();
        tipoSaidaRadioBotao = new javax.swing.JRadioButton();
        dataSaidaRadioBotao = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        registrarSaidaBotao = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaSaida = new javax.swing.JTable();
        editarSaidaBotao = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        vendaSaidaRadioBotao = new javax.swing.JRadioButton();
        percaSaidaRadioBotao = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dataInicioSaidaTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dataInicioSaidaTextField.setText("dd-mm-yyyy");
        dataInicioSaidaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataInicioSaidaTextFieldActionPerformed(evt);
            }
        });

        dataFinalSaidaTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dataFinalSaidaTextField.setText("dd-mm-yyyy");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Data Inicio");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Data Final");

        buscarSaidaBotao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        buscarSaidaBotao.setText("Buscar");
        buscarSaidaBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarSaidaBotaoActionPerformed(evt);
            }
        });

        nomeProdutoTextField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nome");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Filtro:");

        filtrosGroup.add(produtoSaidaRadioBotao);
        produtoSaidaRadioBotao.setText("Produto");
        produtoSaidaRadioBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoSaidaRadioBotaoActionPerformed(evt);
            }
        });

        filtrosGroup.add(tipoSaidaRadioBotao);
        tipoSaidaRadioBotao.setText("Tipo");
        tipoSaidaRadioBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoSaidaRadioBotaoActionPerformed(evt);
            }
        });

        filtrosGroup.add(dataSaidaRadioBotao);
        dataSaidaRadioBotao.setText("Data");
        dataSaidaRadioBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataSaidaRadioBotaoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jLabel5.setText("Buscar saida");

        registrarSaidaBotao.setBackground(new java.awt.Color(143, 235, 153));
        registrarSaidaBotao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        registrarSaidaBotao.setText("Resgistar Saída");
        registrarSaidaBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarSaidaBotaoActionPerformed(evt);
            }
        });

        tabelaSaida.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome do Produto", "Tipo", "Data"
            }
        ));
        jScrollPane2.setViewportView(tabelaSaida);
        if (tabelaSaida.getColumnModel().getColumnCount() > 0) {
            tabelaSaida.getColumnModel().getColumn(0).setHeaderValue("Nome do Produto");
            tabelaSaida.getColumnModel().getColumn(1).setHeaderValue("Tipo");
            tabelaSaida.getColumnModel().getColumn(2).setHeaderValue("Data");
        }

        editarSaidaBotao.setBackground(new java.awt.Color(231, 235, 155));
        editarSaidaBotao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        editarSaidaBotao.setText("Editar");
        editarSaidaBotao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarSaidaBotaoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tipo de saída:");

        tiposGroup.add(vendaSaidaRadioBotao);
        vendaSaidaRadioBotao.setText("Venda");

        tiposGroup.add(percaSaidaRadioBotao);
        percaSaidaRadioBotao.setText("Perca");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(editarSaidaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(registrarSaidaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(nomeProdutoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(dataInicioSaidaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18)
                                            .addComponent(dataFinalSaidaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 77, Short.MAX_VALUE)
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(vendaSaidaRadioBotao)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(percaSaidaRadioBotao)))
                                    .addGap(102, 102, 102)
                                    .addComponent(buscarSaidaBotao)
                                    .addGap(9, 9, 9)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(produtoSaidaRadioBotao)
                                .addGap(18, 18, 18)
                                .addComponent(tipoSaidaRadioBotao)
                                .addGap(18, 18, 18)
                                .addComponent(dataSaidaRadioBotao)))
                        .addContainerGap(40, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(produtoSaidaRadioBotao)
                    .addComponent(tipoSaidaRadioBotao)
                    .addComponent(dataSaidaRadioBotao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nomeProdutoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(vendaSaidaRadioBotao)
                        .addComponent(percaSaidaRadioBotao)
                        .addComponent(buscarSaidaBotao))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(dataInicioSaidaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dataFinalSaidaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registrarSaidaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarSaidaBotao, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void desativarTudo(){
        
        nomeProdutoTextField.setEnabled(false);
        buscarSaidaBotao.setEnabled(false);
        dataInicioSaidaTextField.setEnabled(false);
        dataFinalSaidaTextField.setEnabled(false);
        for (AbstractButton button : Collections.list(tiposGroup.getElements())) {
            button.setEnabled(false);
        }
    };
    
    
    private void dataInicioSaidaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataInicioSaidaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dataInicioSaidaTextFieldActionPerformed

    private void registrarSaidaBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarSaidaBotaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarSaidaBotaoActionPerformed

    private void editarSaidaBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarSaidaBotaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editarSaidaBotaoActionPerformed

    private void produtoSaidaRadioBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoSaidaRadioBotaoActionPerformed
        
        nomeProdutoTextField.setEnabled(true);
        buscarSaidaBotao.setEnabled(true);
        dataInicioSaidaTextField.setEnabled(false);
        dataFinalSaidaTextField.setEnabled(false);
        for (AbstractButton button : Collections.list(tiposGroup.getElements())) {
            button.setEnabled(false);
        }
                
    }//GEN-LAST:event_produtoSaidaRadioBotaoActionPerformed

    private void tipoSaidaRadioBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoSaidaRadioBotaoActionPerformed
        nomeProdutoTextField.setEnabled(false);
        buscarSaidaBotao.setEnabled(true);
        dataInicioSaidaTextField.setEnabled(false);
        dataFinalSaidaTextField.setEnabled(false);
        for (AbstractButton button : Collections.list(tiposGroup.getElements())) {
            button.setEnabled(true);
        }
    }//GEN-LAST:event_tipoSaidaRadioBotaoActionPerformed

    private void dataSaidaRadioBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataSaidaRadioBotaoActionPerformed
        nomeProdutoTextField.setEnabled(false);
        buscarSaidaBotao.setEnabled(true);
        dataInicioSaidaTextField.setEnabled(true);
        dataFinalSaidaTextField.setEnabled(true);
        for (AbstractButton button : Collections.list(tiposGroup.getElements())) {
            button.setEnabled(false);
        }
    }//GEN-LAST:event_dataSaidaRadioBotaoActionPerformed

    private void buscarSaidaBotaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarSaidaBotaoActionPerformed
        DefaultTableModel modelo = (DefaultTableModel) tabelaSaida.getModel();
        
        modelo.setRowCount(0);
        
        SaidaController saidas = new SaidaController();
        List<Object[]> dadosTabela = new ArrayList();
        
        String nome = nomeProdutoTextField.getText();
        String filtro;
        String tipoFiltro = null;
        String dataInicio = dataInicioSaidaTextField.getText();
        String dataFim = dataFinalSaidaTextField.getText();
        
        if (produtoSaidaRadioBotao.isSelected()) {
            
            try {
                filtro = "Produto";
                
                dadosTabela = saidas.buscarPorFiltros(nome, filtro, tipoFiltro, dataInicio, dataFim);
            } catch (ParseException ex) {
                Logger.getLogger(BuscarSaida.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } else if (tipoSaidaRadioBotao.isSelected()) {
            try {
                filtro = "Tipo";
                
                if(vendaSaidaRadioBotao.isSelected()){
                    tipoFiltro = "Venda";
                } else {
                    tipoFiltro = "Perca";
                }
                
                dadosTabela = saidas.buscarPorFiltros(nome, filtro, tipoFiltro, dataInicio, dataFim);
            } catch (ParseException ex) {
                Logger.getLogger(BuscarSaida.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (dataSaidaRadioBotao.isSelected()) {
            try {
                filtro = "Data";
                
                dadosTabela = saidas.buscarPorFiltros(nome, filtro, tipoFiltro, dataInicio, dataFim);
            } catch (ParseException ex) {
                Logger.getLogger(BuscarSaida.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                filtro = null;
                
                dadosTabela = saidas.buscarPorFiltros(nome, filtro, tipoFiltro, dataInicio, dataFim);
            } catch (ParseException ex) {
                Logger.getLogger(BuscarSaida.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        for (Object[] linha : dadosTabela) {
            modelo.addRow(linha);
        }
    }//GEN-LAST:event_buscarSaidaBotaoActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarSaidaBotao;
    private javax.swing.JTextField dataFinalSaidaTextField;
    private javax.swing.JTextField dataInicioSaidaTextField;
    private javax.swing.JRadioButton dataSaidaRadioBotao;
    private javax.swing.JButton editarSaidaBotao;
    private javax.swing.ButtonGroup filtrosGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomeProdutoTextField;
    private javax.swing.JRadioButton percaSaidaRadioBotao;
    private javax.swing.JRadioButton produtoSaidaRadioBotao;
    private javax.swing.JButton registrarSaidaBotao;
    private javax.swing.JTable tabelaSaida;
    private javax.swing.JRadioButton tipoSaidaRadioBotao;
    private javax.swing.ButtonGroup tiposGroup;
    private javax.swing.JRadioButton vendaSaidaRadioBotao;
    // End of variables declaration//GEN-END:variables
}
