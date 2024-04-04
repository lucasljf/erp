
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Produto;
import modelo.Saida;

public class SaidaDAO {

    private final Connection conexao = new Conexao().getConexao();
    
    private boolean alterarStatus(Saida saida){
    	
    	String sqlSelect = "SELECT * FROM tb_saida WHERE id = ?";
        String sqlUpdate = "UPDATE tb_saida SET status = ? WHERE id = ?";
    	
    	try {
            PreparedStatement stmt = this.conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, saida.getId());

            ResultSet rs = stmt.executeQuery();

            int status = rs.getInt("status");

            stmt = this.conexao.prepareStatement(sqlUpdate);
            if(status == 1){
                stmt.setInt(1, 0);
            } else {
                stmt.setInt(1, 1);
            }
            stmt.setInt(2, saida.getId());

            stmt.executeUpdate();
            stmt.close();

            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
   }
}
