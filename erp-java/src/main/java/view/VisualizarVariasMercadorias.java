/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.JFrame;

/**
 *
 * @author alexandreneves
 */
public class VisualizarVariasMercadorias extends javax.swing.JFrame {

    /**
     * Creates new form VisualizarVariasMercadorias
     */
    public VisualizarVariasMercadorias() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMercadorias = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        txtBarraPesquisa = new javax.swing.JTextField();
        rdBtnAtivo = new javax.swing.JRadioButton();
        rdBtnInativo = new javax.swing.JRadioButton();
        lblStatus = new javax.swing.JLabel();
        btnAddProduto = new javax.swing.JButton();
        btnVoltaMuitos = new javax.swing.JButton();
        btnAvancaMuitos = new javax.swing.JButton();
        btnVoltaUm = new javax.swing.JButton();
        btnAvancaUm = new javax.swing.JButton();
        lblPagina1 = new javax.swing.JLabel();
        lblPagina2 = new javax.swing.JLabel();
        lblPagina3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualizar Mercadorias");
        setSize(new java.awt.Dimension(0, 0));

        tblMercadorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id", "nome", "descrição", "lucro(%)", "qtd Mínima"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblMercadorias);
        if (tblMercadorias.getColumnModel().getColumnCount() > 0) {
            tblMercadorias.getColumnModel().getColumn(0).setResizable(false);
            tblMercadorias.getColumnModel().getColumn(4).setResizable(false);
        }

        lblTitulo.setFont(new java.awt.Font("Hack", 0, 24)); // NOI18N
        lblTitulo.setText("Minhas Mercadorias");

        txtBarraPesquisa.setText("Buscar por nome ou código de barras...");
        txtBarraPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarraPesquisaActionPerformed(evt);
            }
        });

        rdBtnAtivo.setText("Ativo");
        rdBtnAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdBtnAtivoActionPerformed(evt);
            }
        });

        rdBtnInativo.setText("Inativo");

        lblStatus.setText("Status do Produto:");

        btnAddProduto.setText("Adicionar Produto");

        btnVoltaMuitos.setText("<<");

        btnAvancaMuitos.setText(">>");

        btnVoltaUm.setText("<");

        btnAvancaUm.setText(">");

        lblPagina1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPagina1.setText("1");

        lblPagina2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPagina2.setText("2");

        lblPagina3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPagina3.setText("3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltaMuitos)
                .addGap(18, 18, 18)
                .addComponent(btnVoltaUm)
                .addGap(18, 18, 18)
                .addComponent(lblPagina1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPagina2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPagina3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAvancaUm)
                .addGap(18, 18, 18)
                .addComponent(btnAvancaMuitos)
                .addGap(391, 391, 391))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblStatus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(rdBtnAtivo)
                                .addGap(18, 18, 18)
                                .addComponent(rdBtnInativo))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                        .addComponent(txtBarraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBarraPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAddProduto)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdBtnAtivo)
                            .addComponent(rdBtnInativo))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltaMuitos)
                    .addComponent(btnAvancaMuitos)
                    .addComponent(btnVoltaUm)
                    .addComponent(btnAvancaUm)
                    .addComponent(lblPagina1)
                    .addComponent(lblPagina2)
                    .addComponent(lblPagina3))
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBarraPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarraPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBarraPesquisaActionPerformed

    private void rdBtnAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdBtnAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdBtnAtivoActionPerformed

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
            java.util.logging.Logger.getLogger(VisualizarVariasMercadorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualizarVariasMercadorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualizarVariasMercadorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualizarVariasMercadorias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VisualizarVariasMercadorias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduto;
    private javax.swing.JButton btnAvancaMuitos;
    private javax.swing.JButton btnAvancaUm;
    private javax.swing.JButton btnVoltaMuitos;
    private javax.swing.JButton btnVoltaUm;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPagina1;
    private javax.swing.JLabel lblPagina2;
    private javax.swing.JLabel lblPagina3;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JRadioButton rdBtnAtivo;
    private javax.swing.JRadioButton rdBtnInativo;
    private javax.swing.JTable tblMercadorias;
    private javax.swing.JTextField txtBarraPesquisa;
    // End of variables declaration//GEN-END:variables
}
