package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Produto;
import modelo.Entrada;
import modelo.Fornecedor;


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
                entrada.setData(rs.getDate("data"));
                entrada.setQuantidade(rs.getInt("quantidade"));
                entrada.setPrecoCusto(rs.getDouble("precoCusto"));
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                entrada.setFornecedor(fornecedor);
                
                entrada.setLote(rs.getString("lote"));
                entrada.setValidade(rs.getDate("validade"));
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
