
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Mercadoria;
import modelo.Produto;
import modelo.Servico;

public class ProdutoDAO {
    private final Connection conexao = new Conexao().getConexao();
    
    public Produto salvar(Produto produto) {
        String sqlSalvarProduto = "INSERT INTO tb_produto (nome, descricao, criado_em, atualizado_em) VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sqlSalvarProduto, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDate(3, new java.sql.Date(produto.getCriadoEm().getTime()));
            stmt.setDate(4, new java.sql.Date(produto.getAtualizadoEm().getTime()));
            
            stmt.execute();
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            produto.setId(rs.getInt(1));
            
            if(produto instanceof Mercadoria){
                Mercadoria mercadoria = (Mercadoria) produto;
                
                String sqlSalvarMercadoria = "UPDATE tb_produto SET quantidade_minima = ?, porcentagem_lucro = ?, perecivel = ? WHERE id = ?";
                
                PreparedStatement stmtMercadoria = this.conexao.prepareStatement(sqlSalvarMercadoria);
                stmtMercadoria.setDouble(1, mercadoria.getQuantidadeMinima());
                stmtMercadoria.setDouble(2, mercadoria.getPorcentagemLucro());
                stmtMercadoria.setBoolean(3, mercadoria.isPerecivel());
                stmtMercadoria.setInt(4, mercadoria.getId());
                
                stmtMercadoria.executeUpdate();
                
            }else if(produto instanceof Servico){
                Servico servico = (Servico) produto;
                
                String sqlSalvarServico = "UPDATE tb_produto SET garantia = ? WHERE id = ?";
                
                PreparedStatement stmtServico = this.conexao.prepareStatement(sqlSalvarServico);
                stmtServico.setString(1, servico.getGarantia());
                stmtServico.setInt(2, servico.getId());
                
                stmt.executeUpdate();
            }
            
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
