
package dao;

import modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;



public class UsuarioDAO {    //  login e senha
    
    private final Connection conexao = new Conexao().getConexao();
    
    public Usuario autenticar(String login, String senha){
        
        String sql = "select * from tb_usuario where login = ? and senha = ?";
        Usuario usuario = new Usuario();
        
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, login);
            stmt.setString(2, senha);
            
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                String nome = rs.getString("nome");
                
                usuario.setNome(nome);
                usuario.setLogin(login);
                usuario.setSenha(senha);
                stmt.close(); 
            }
            
            return usuario;
            
        } catch (Exception e) {
            throw new RuntimeException();
        }
       
    }
        
        
        
        
        
    }
        
        
                
        
       
  
    
   
    


