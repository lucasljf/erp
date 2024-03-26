
package dao;


import modelo.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
    private final Connection conexao = new Conexao().getConexao();

    public boolean alterarStatus(Fornecedor fornecedor){
        String sqlSelect = "SELECT * FROM tb_fornecedor WHERE id = ?";

        String sqlUpdate = "UPDATE tb_fornecedor WHERE id = ? SET status = ?";
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, fornecedor.getId());

            ResultSet rs = stmt.executeQuery();

            int status = rs.getInt("status");

            stmt = this.conexao.prepareStatement(sqlUpdate);
            stmt.setInt(1, fornecedor.getId());

            if(status == 1){
                stmt.setInt(2, 0);
            } else {
                stmt.setInt(2, 1);
            }
            stmt.execute();
            stmt.close();

            return true;
        } catch (Exception exception){
            return false;
        }
    }
    
    public List<Fornecedor> buscar (String nome, boolean status){
        List<Fornecedor> fornecedores = new ArrayList<>();
        
        try {
            String sql = "SELECT * FROM tb_fornecedor WHERE nome LIKE ? AND status = ?";
            PreparedStatement stmt = conexao.prepareStatement (sql);
            stmt.setString (1, "%" + nome + "%");
            stmt.setBoolean(2, status);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rs.getInt("id"));
                fornecedor.setNome(rs.getString("nome"));
                fornecedor.setTelefone(rs.getString("telefone"));
                fornecedor.setCnpj(rs.getString("cnpj"));
                fornecedor.setEmail(rs.getString("email"));
                
                fornecedores.add(fornecedor);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return fornecedores;
        }
    }
  
