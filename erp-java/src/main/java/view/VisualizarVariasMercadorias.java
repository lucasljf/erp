package view;
import controlador.MercadoriaController;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import modelo.Mercadoria;
import modelo.Produto;

public class VisualizarVariasMercadorias extends javax.swing.JFrame {
    private final MercadoriaController controller;
    private int paginaAtual = 1;
    private final int QTDE_POR_PAGINA = 10;
    private int totalPaginas;
    private ArrayList<Produto> produtos;

    public VisualizarVariasMercadorias() {
        controller = new MercadoriaController();        
        initComponents();
        produtos = controller.buscarTodos(true);
        addContentToTable();
        this.setVisible(true);        
        tblMercadorias.setAutoCreateRowSorter(true);
    }

    /*
    * @addContentToTable exibe o conteúdo de @produtos em páginas com 10 itens.
    * Antes de chamar o método certifique de atualizar a lista de produtos
    * da forma que desejar.
    */
    private void addContentToTable() {
        DefaultTableModel model = (DefaultTableModel) tblMercadorias.getModel();
        model.setRowCount(0);
        
        lblPagina2.setText(String.valueOf(paginaAtual));
        int startIndex = (paginaAtual - 1) * QTDE_POR_PAGINA;
        int endIndex = Math.min(startIndex + QTDE_POR_PAGINA, produtos.size());
        
        totalPaginas = (int) Math.ceil((double) produtos.size() / QTDE_POR_PAGINA);

        if (!produtos.isEmpty()) {
            for (int i = startIndex; i < endIndex; i++) {
                Produto produto = produtos.get(i);
                if (produto instanceof Mercadoria) {
                    Mercadoria mercadoria = (Mercadoria) produto;
                    model.addRow(new Object[]{
                        mercadoria.getId(),
                        mercadoria.getNome(),
                        mercadoria.getDescricao(),
                        mercadoria.getPorcentagemLucro(),
                        mercadoria.getQuantidadeMinima()
                    });
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nenhum registro encontrado.");
        }
        updateNavigationButtons();
    }

    private void updateNavigationButtons() {
        btnAvancaUm.setEnabled(paginaAtual < totalPaginas);
        btnVoltaUm.setEnabled(paginaAtual > 1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblMercadorias = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        txtBarraPesquisa = new javax.swing.JTextField();
        btnAddProduto = new javax.swing.JButton();
        tglStatus = new javax.swing.JToggleButton();
        btnPesquisar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnVoltaMuitos = new javax.swing.JButton();
        btnVoltaUm = new javax.swing.JButton();
        lblPagina2 = new javax.swing.JLabel();
        btnAvancaUm = new javax.swing.JButton();
        btnAvancaMuitos = new javax.swing.JButton();
        lblBusca = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visualizar Mercadorias");
        setMinimumSize(new java.awt.Dimension(1200, 680));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 680));
        getContentPane().setLayout(null);

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
            tblMercadorias.getColumnModel().getColumn(0).setMinWidth(40);
            tblMercadorias.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblMercadorias.getColumnModel().getColumn(0).setMaxWidth(40);
            tblMercadorias.getColumnModel().getColumn(4).setResizable(false);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 153, 1198, 438);

        lblTitulo.setFont(new java.awt.Font("Fira Sans Compressed Heavy", 0, 36)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Mercadorias");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(0, 6, 730, 140);

        txtBarraPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBarraPesquisaActionPerformed(evt);
            }
        });
        getContentPane().add(txtBarraPesquisa);
        txtBarraPesquisa.setBounds(810, 40, 363, 23);

        btnAddProduto.setText("Adicionar Produto");
        btnAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddProduto);
        btnAddProduto.setBounds(840, 70, 190, 23);

        tglStatus.setText("Alternar Status");
        tglStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tglStatusActionPerformed(evt);
            }
        });
        getContentPane().add(tglStatus);
        tglStatus.setBounds(1020, 120, 150, 23);

        btnPesquisar.setText("pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisar);
        btnPesquisar.setBounds(1050, 70, 120, 23);

        btnVoltaMuitos.setText("<<");
        jPanel1.add(btnVoltaMuitos);

        btnVoltaUm.setText("<");
        btnVoltaUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltaUmActionPerformed(evt);
            }
        });
        jPanel1.add(btnVoltaUm);

        lblPagina2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPagina2.setText("2");
        jPanel1.add(lblPagina2);

        btnAvancaUm.setText(">");
        btnAvancaUm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvancaUmActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvancaUm);

        btnAvancaMuitos.setText(">>");
        jPanel1.add(btnAvancaMuitos);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 610, 1200, 30);

        lblBusca.setText("Buscar por nome ou código de barras:");
        getContentPane().add(lblBusca);
        lblBusca.setBounds(810, 20, 360, 17);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBarraPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBarraPesquisaActionPerformed
    }//GEN-LAST:event_txtBarraPesquisaActionPerformed
    

    
    private void tglStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tglStatusActionPerformed
        if(tglStatus.isSelected()){
            tglStatus.setText("Ativos");
        } else {
            tglStatus.setText("Inativos");
        }
    }//GEN-LAST:event_tglStatusActionPerformed

    private void btnAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdutoActionPerformed

    }//GEN-LAST:event_btnAddProdutoActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnVoltaUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltaUmActionPerformed
        if (paginaAtual > 1) {
            paginaAtual--;
            addContentToTable();
        }
    }//GEN-LAST:event_btnVoltaUmActionPerformed

    private void btnAvancaUmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvancaUmActionPerformed
        if (paginaAtual < totalPaginas) {
            paginaAtual++;
            addContentToTable();
        }
    }//GEN-LAST:event_btnAvancaUmActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduto;
    private javax.swing.JButton btnAvancaMuitos;
    private javax.swing.JButton btnAvancaUm;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltaMuitos;
    private javax.swing.JButton btnVoltaUm;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblPagina2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tblMercadorias;
    private javax.swing.JToggleButton tglStatus;
    private javax.swing.JTextField txtBarraPesquisa;
    // End of variables declaration//GEN-END:variables


}
