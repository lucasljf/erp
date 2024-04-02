package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Mercadoria;
import modelo.Produto;
import modelo.Servico;

public class ProdutoDAO {

    private final Connection conexao = new Conexao().getConexao();

    public boolean alterarStatus(Produto produto) {
        int statusAtual, novoStatus;
        boolean statusAlterado = false;
        String sqlSelectStatus = "SELECT status FROM tb_produto WHERE id = ?";
        String sqlUpdateStatus = "UPDATE tb_produto SET status = ? WHERE id = ?";
        
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sqlSelectStatus);
            stmt.setInt(1, produto.getId());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                statusAtual = rs.getInt("status");
                novoStatus = (statusAtual == 1) ? 0 : 1;
                
                stmt = this.conexao.prepareStatement(sqlUpdateStatus);
                stmt.setInt(1, novoStatus);
                stmt.setInt(2, produto.getId());
                stmt.execute();
                stmt.close();
                statusAlterado = true;  
            }            
            
        } catch (Exception e) {
            throw new RuntimeException();
        }
        
        return statusAlterado;
        
    }
    
    public Produto buscar(int id, boolean status) {
        String tipoProduto;

        try {
            String sql = "SELECT * FROM tb_produto WHERE id = ? AND status = ?";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setBoolean(2, status);

            ResultSet rs = stmt.executeQuery();
            
            tipoProduto = rs.getString("tipo_produto");

            if (rs.next()) {
                if(tipoProduto.equalsIgnoreCase("M")){
                    Mercadoria produto = new Mercadoria();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setCriadoEm(rs.getDate("criado_em"));
                    produto.setAtualizadoEm(rs.getDate("atualizado_em"));
                    produto.setQuantidadeMinima(rs.getDouble("quantidade_minima"));
                    produto.setPorcentagemLucro(rs.getDouble("porcentagem_lucro"));
                    produto.setPerecivel(rs.getBoolean("perecivel"));
                    
                    return produto;
                } else {
                    Servico produto = new Servico();
                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setCriadoEm(rs.getDate("criado_em"));
                    produto.setAtualizadoEm(rs.getDate("atualizado_em"));
                    produto.setGarantia(rs.getString("garantia"));
                    
                    return produto;
                }
            }

            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }        
    }

}
