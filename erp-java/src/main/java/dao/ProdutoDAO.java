package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import modelo.Produto;

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

}
