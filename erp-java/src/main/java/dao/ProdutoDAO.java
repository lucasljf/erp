
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Produto;

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
            
            return produto;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
