package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Produto;


public class EntradaDAO {
    private final Connection conexao = new Conexao().getConexao();
    
    public ArrayList<Entrada> buscar(Produto produto){
        String sql = "SELECT * FROM tb_entrada WHERE produto_id=?";
        
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
               
            ResultSet rs = stmt.executeQuery();
            ArrayList<Entrada> entradas = new ArrayList<>();

            while (rs.next()) {
                Entrada entrada = new Entrada(rs.getInt("id"));
                entradas.add(entrada);
            }
            
            rs.close();
            stmt.close();
            return entradas;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
