
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Entrada;

public class EntradaDAO {
    
   private Connection conexao = new Conexao().getConexao();
   
    public List<Entrada> buscar(String inicio, String fim){
    List<Entrada> entradasEncontradas = new ArrayList<>();

    String sql = "SELECT * FROM tb_entrada WHERE data BETWEEN ? AND ?";

    
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, inicio);
            stmt.setString(2, fim);
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Entrada entrada = new Entrada();
                entrada.setId(rs.getInt("id"));
                entrada.setData(rs.getString("data"));
                entrada.setQuantidade(rs.getInt("quantidade"));
                entrada.setPrecoCusto(rs.getDouble("preco_custo"));
                entrada.setLote(rs.getString("lote"));
                entrada.setProdutoId(rs.getInt("produto_id"));
                entrada.setValidade(rs.getString("validade"));
                entrada.setFornecedorId(rs.getInt("fornecedor_id"));
                entrada.setStatus(rs.getInt("status"));
                
                entradasEncontradas.add(entrada);
            }
        } catch(Exception e) {
            throw new RuntimeException();
        }
        
        return entradasEncontradas;
    }
}


