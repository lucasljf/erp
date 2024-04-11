package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Saida;

public class SaidaDAO {
    private final Connection conexao = new Conexao().getConexao();
    
    public Saida salvar(Saida saida) {
        String sql = "INSERT INTO tb_saida (produto, data, desconto, tipoSaida) VALUES (?, ?, ?, ?)";
                
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, saida.getProduto().getId());
            stmt.setDate(2, saida.getData());
            stmt.setDouble(3, saida.getDesconto());
            stmt.setString(4, saida.getTipoSaida());
            
            stmt.execute();
            
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            
            saida.setId(rs.getInt(1));
    
            stmt.close();
    
            return saida;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}