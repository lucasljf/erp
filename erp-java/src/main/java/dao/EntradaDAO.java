package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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
                int id = rs.getInt("id");
                Date data = rs.getDate("data");
                int quantidade = rs.getInt("quantidade");
                double precoCusto = rs.getDouble("preco_custo");
                String lote = rs.getString("lote");
                Date validade = rs.getDate("validade");
                
                int id_fornecedor = rs.getInt("fornecedor_id");
                
                FornecedorDao fornecedorDao = new FornecedorDao();
                Fornecedor fornecedor = fornecedorDao.buscar(id_fornecedor, 1);
                
                Entrada entrada = new Entrada(id, data, quantidade, precoCusto, produto, fornecedor, lote, validade);
                
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
