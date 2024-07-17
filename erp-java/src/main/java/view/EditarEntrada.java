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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        loteProduto = new javax.swing.JTextField();
        fornecedorProduto = new javax.swing.JTextField();
        nomeProduto = new javax.swing.JTextField();
        dataProduto = new javax.swing.JTextField();
        precoCustoProduto = new javax.swing.JTextField();
        validadeProduto = new javax.swing.JTextField();
        fabricacaoProduto = new javax.swing.JTextField();
        cancelarEntrada = new javax.swing.JButton();
        salvarEntrada = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        quantidadeProduto = new javax.swing.JTextField();
        descricaoProduto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("CADASTRO DE ENTRADAS");

        jLabel2.setText("Nome:");

        jLabel3.setText("Data:");

        jLabel4.setText("Quantidade:");

        jLabel5.setText("Preço de custo:");

        jLabel6.setText("Fornecedor:");

        jLabel7.setText("Lote:");

        jLabel8.setText("Validade");

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

        dataProduto.setEditable(false);
        dataProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataProdutoActionPerformed(evt);
            }
        });

        precoCustoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoCustoProdutoActionPerformed(evt);
            }
        });

        validadeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validadeProdutoActionPerformed(evt);
            }
        });

        fabricacaoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fabricacaoProdutoActionPerformed(evt);
            }
        });

        cancelarEntrada.setText("CANCELAR");
        cancelarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEntradaActionPerformed(evt);
            }
        });

        salvarEntrada.setText("SALVAR");
        salvarEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarEntradaActionPerformed(evt);
            }
        });

        jLabel9.setText("Descrição");

        jLabel10.setText("Fabricação");

        quantidadeProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantidadeProdutoActionPerformed(evt);
            }
        });

        descricaoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descricaoProdutoActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(validadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(loteProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fabricacaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(precoCustoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fornecedorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(quantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(112, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(descricaoProduto)
                                .addGap(35, 35, 35)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dataProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cancelarEntrada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(salvarEntrada)
                                .addGap(114, 114, 114))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fornecedorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(precoCustoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loteProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fabricacaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(quantidadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel10))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(validadeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descricaoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelarEntrada)
                    .addComponent(salvarEntrada))
                .addGap(18, 18, 18))
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
        dataProduto.setText(dateString);
        dataProduto.setEditable(false);
    }//GEN-LAST:event_dataProdutoActionPerformed

    private void precoCustoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoCustoProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precoCustoProdutoActionPerformed

    private void validadeProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validadeProdutoActionPerformed


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
        String dataString = validadeProduto.getText();

        Date validadeProdutoData = formato.parse(dataString);
        String nome = nomeProduto.getText(); // Suponho que `nomeProduto` seja o nome do produto
        String data = dataProduto.getText();
        int lote = Integer.parseInt(loteProduto.getText());
        String fornecedor = fornecedorProduto.getText();
        String descricao = descricaoProduto.getText();
        String fabricacao = fabricacaoProduto.getText();
        double precoCusto = Double.parseDouble(precoCustoProduto.getText());
        int quantidade = Integer.parseInt(quantidadeProduto.getText());

        // Criando um objeto Produto com as informações obtidas
        Produto produto = new Produto(nome, descricao, fabricacao, validadeProdutoData);

        EntradaController entradaController = new EntradaController();
        entradaController.cadastrarEntrada(data, produto, quantidade, precoCusto, fornecedor, String.valueOf(lote), validadeProdutoData);

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
    private javax.swing.JButton cancelarEntrada;
    private javax.swing.JTextField dataProduto;
    private javax.swing.JTextField descricaoProduto;
    private javax.swing.JTextField fabricacaoProduto;
    private javax.swing.JTextField fornecedorProduto;
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
    private javax.swing.JTextField loteProduto;
    private javax.swing.JTextField nomeProduto;
    private javax.swing.JTextField precoCustoProduto;
    private javax.swing.JTextField quantidadeProduto;
    private javax.swing.JButton salvarEntrada;
    private javax.swing.JTextField validadeProduto;
    // End of variables declaration//GEN-END:variables
}
