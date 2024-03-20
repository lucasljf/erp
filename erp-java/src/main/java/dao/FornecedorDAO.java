
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Fornecedor;

public class FornecedorDAO {
    
    public Fornecedor salvar(Fornecedor fornecedor){
    
        Conexao con = new Conexao();
        con.getConexao();
      
        String sql = "INSERT INTO fornecedor (nome, telefone, cnpj, email) VALUES (?, ?, ?, ?)";
        
        try {
        PreparedStatement stmt = this.con.preparedStatement(sql);
        stmt.setString(1, fornecedor.getNome());
        stmt.setString(2, fornecedor.getTelefone());
        stmt.setString(3, fornecedor.getCnpj());
        stmt.setString(4, fornecedor.getEmail());
        
        stmt.execute();
        stmt.close();
        
        } catch (SQLException e){
            throw new RuntimeException();
            
        }
        
        return fornecedor;
    }

}
