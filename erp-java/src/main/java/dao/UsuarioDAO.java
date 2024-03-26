
package dao;

import modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;



public class UsuarioDAO {    //  login e senha
    
    private final Connection conexao = new Conexao().getConexao();
    
    public Usuario autenticar(Usuario usuario){
        
        String sql = "select * from tb_usuario where login = ? and senha = ?";
        
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, login.getLogin());
            stmt.setString(2, senha.getSenha());
            
            ResultSet rs = stmt.executeQuery();

            stmt.execute();
            stmt.close();
            
            

        } catch (Exception e) {
            throw new RuntimeException();
            
        }
        return usuario;
        
        
    }
        
        
        
        
        
    }
        
        
                
        
       
  
    
   
    


