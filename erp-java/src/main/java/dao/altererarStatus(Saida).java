
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
    
    private void alterarStatus(Saida saida){
    	
    	String sql = "update tb_saida set status = ? where tb_saida.id = ?";
    	
    	conexao = new Conexao().getConexao();
    	
    	try {

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, saida.getStatus());
            stmt.setInt(2, saida.getId());
            
            stmt.execute();
            stmt.close();
       
    	} catch (SQLException erro) {
    		
    		JOptionPane.showInternalMessageDialog(null, "SaidaDAO alterarStatus()" + erro);
    	}


    }
