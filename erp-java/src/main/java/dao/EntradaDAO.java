/* @author: Paulo Prado */

package dao;

import modelo.Entrada;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EntradaDAO {
    private final Connection conexao = new Conexao().getConexao();

    public boolean alterarStatus(Entrada entrada){
        String sqlSelect = "SELECT * FROM tb_entrada WHERE id = ?";
        String sqlUpdate = "UPDATE tb_entrada SET status = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, entrada.getId());

            ResultSet rs = stmt.executeQuery();

            int status = rs.getInt("status");

            stmt = this.conexao.prepareStatement(sqlUpdate);
            if(status == 1){
                stmt.setInt(1, 0);
            } else {
                stmt.setInt(1, 1);
            }
            stmt.setInt(2, entrada.getId());

            stmt.executeUpdate();
            stmt.close();

            return true;
        } catch (Exception exception){
            exception.printStackTrace();
            return false;
        }
    }
}