/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.Cad_entradas to edit this template
 */
package view;

import controlador.EntradaController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Fornecedor;
import modelo.Mercadoria;
import modelo.Produto;

/**
 *
 * @author 55629
 */
public class Cad_entradas extends javax.swing.JFrame {

    /**
     * Creates new form java
     */
    public Cad_entradas() {
        initComponents();
    }
    
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    Date date = new Date();
    String dateString = formatter.format(date);

    boolean perecivel = false;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        loteProduto = new javax.swing.JTextField();
        fornecedorProduto = new javax.swing.JTextField();
        nomeProduto = new javax.swing.JTextField();
        dataEntrada = new javax.swing.JTextField();
        precoCustoProduto = new javax.swing.JTextField();
        qntdProduto = new javax.swing.JTextField();
        fabricacaoProduto = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        btnTrue = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        validadeProduto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        porcLucro = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        qntdMinima = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("CADASTRO DE ENTRADAS");

        jLabel2.setText("Produto:");

        jLabel3.setText("Data:");

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Preço de custo:");

        jLabel6.setText("Fornecedor:");

        jLabel7.setText("Lote:");

        jLabel8.setText("Validade");

        jButton1.setText("SALVAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        loteProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loteProdutoActionPerformed(evt);
            }
        });

        fornecedorProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fornecedorProdutoActionPerformed(evt);
            }
        });

        nomeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeProdutoActionPerformed(evt);
            }
        });

        dataEntrada.setEditable(false);
        dataEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataEntradaActionPerformed(evt);
            }
        });

        precoCustoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoCustoProdutoActionPerformed(evt);
            }
        });

        qntdProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qntdProdutoActionPerformed(evt);
            }
        });

        fabricacaoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fabricacaoProdutoActionPerformed(evt);
            }
        });

        jButton2.setText("CANCELAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnTrue.setText("Sim");
        btnTrue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrueActionPerformed(evt);
            }
        });

        jRadioButton2.setText("Não");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel9.setText("Produto Perecível");

        jLabel10.setText("% Lucro:");

        validadeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validadeProdutoActionPerformed(evt);
            }
        });

        jLabel11.setText("Fabricado:");

        porcLucro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                porcLucroActionPerformed(evt);
            }
        });

        jLabel12.setText("Qntd minima:");

        qntdMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qntdMinimaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(qntdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(qntdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fornecedorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(validadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loteProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTrue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton2)))
                        .addContainerGap(85, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(precoCustoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fabricacaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(porcLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(191, 191, 191))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fornecedorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 95, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(qntdProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12)
                                            .addComponent(qntdMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel5)
                                            .addComponent(precoCustoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8)
                                            .addComponent(validadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fabricacaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(loteProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(porcLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(btnTrue)
                            .addComponent(jRadioButton2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loteProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loteProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loteProdutoActionPerformed

    private void fornecedorProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fornecedorProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fornecedorProdutoActionPerformed

    private void nomeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeProdutoActionPerformed

    private void dataProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataProdutoActionPerformed
      
    }//GEN-LAST:event_dataProdutoActionPerformed

    private void precoCustoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoCustoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precoCustoProdutoActionPerformed

    private void fabricacaoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validadeProdutoActionPerformed


    }//GEN-LAST:event_validadeProdutoActionPerformed

    private void fabricacaoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fabricacaoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fabricacaoProdutoActionPerformed

    private void cancelarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEntradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarEntradaActionPerformed

    private void salvarEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarEntradaActionPerformed
 try {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        
        // Parse das datas
        Date validadeProdutoData = formato.parse(validadeProduto.getText());
        Date fabricacao = formato.parse(fabricacaoProduto.getText());
        
        // Captura dos outros dados
        String nome = nomeProduto.getText();
        String lote = loteProduto.getText();
        String fornecedor = fornecedorProduto.getText();
        double precoCusto = Double.parseDouble(precoCustoProduto.getText());
        double porcent = Double.parseDouble(porcLucro.getText());

        int quantidade = Integer.parseInt(qntdProduto.getText());
        int qntdMin  = Integer.parseInt(qntdMinima.getText());
        
        Mercadoria mercadoria = new Mercadoria(nome, fornecedor, fabricacao, validadeProdutoData, qntdMin, porcent, perecivel);
       Fornecedor fornecedor1 = new Fornecedor(fornecedor);
        
        
        EntradaController entradaController = new EntradaController();
        entradaController.cadastrarEntrada(mercadoria, new Date(), quantidade, precoCusto, fornecedor1, lote, validadeProdutoData);


    } catch (NumberFormatException e) {
        System.err.println("Erro ao converter o número: " + e.getMessage());
        e.printStackTrace();
    } catch (ParseException e) {
        System.err.println("Erro ao converter a data: " + e.getMessage());
        e.printStackTrace();
    } catch (Exception e) {
        System.err.println("Erro inesperado: " + e.getMessage());
        e.printStackTrace();
    }

    }//GEN-LAST:event_salvarEntradaActionPerformed

    private void quantidadeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantidadeProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantidadeProdutoActionPerformed

    private void descricaoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descricaoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descricaoProdutoActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void btnTrueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrueActionPerformed
        boolean perecivel = btnTrue.isSelected();
    }//GEN-LAST:event_btnTrueActionPerformed

    private void validadeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validadeProduto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_validadeProduto1ActionPerformed

    private void porcLucroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_porcLucroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_porcLucroActionPerformed

    private void qntdMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qntdMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qntdMinimaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Cad_entradas.util.logging.Logger.getLogger(Cad_entradas.class.getName()).log(Cad_entradas.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Cad_entradas.util.logging.Logger.getLogger(Cad_entradas.class.getName()).log(Cad_entradas.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Cad_entradas.util.logging.Logger.getLogger(Cad_entradas.class.getName()).log(Cad_entradas.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Cad_entradas.util.logging.Logger.getLogger(Cad_entradas.class.getName()).log(Cad_entradas.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        Cad_entradas.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cad_entradas().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton btnTrue;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField dataEntrada;
    private javax.swing.JTextField fabricacaoProduto;
    private javax.swing.JTextField fornecedorProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField loteProduto;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JTextField porcLucro;
    private javax.swing.JTextField precoCustoProduto;
    private javax.swing.JTextField qntdMinima;
    private javax.swing.JTextField qntdProduto;
    private javax.swing.JTextField validadeProduto;
    // End of variables declaration//GEN-END:variables
}
