package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Saida;

public class SaidaDAO {
    
    private Connection conexao = new Conexao().getConexao();
    
    public List<Saida> buscar(Saida tipoSaida, boolean status) {
        
        String nome_tipoSaida = tipoSaida.getTipoSaida();
        int status_boolean = status ? 1 : 0;
        
        List<Saida> saidaEncontrada = new ArrayList<Saida>();
        
        String sql = "SELECT * FROM tb_saida WHERE tipo_saida LIKE '%?%' AND status = ?"; 
        
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);       
            
            stmt.setString(1, tipoSaida.getTipoSaida());
            stmt.setBoolean(2, status);
            stmt.execute();
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Saida saida = new Saida();
                saida.setTipoSaida(rs.getString("tipo_saida"));
                saidaEncontrada.add(saida);
            }
            return saidaEncontrada;
            
        } catch (SQLException e) {
            return saidaEncontrada;
        }
    }

}
