package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modelo.Produto;
import modelo.Saida;

public class SaidaDAO {

    private Connection conexao = new Conexao().getConexao();

    public ArrayList<Saida> buscar(String tipoSaida) {

        String sql = "SELECT * FROM tb_saida WHERE tipo_saida LIKE '%?%'";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);

            stmt.setString(1, tipoSaida);

            ResultSet rs = stmt.executeQuery();

            ArrayList<Saida> saidaEncontrada = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                
                int id_produto = rs.getInt("produto_id");
                ProdutoDao produtoDao = new ProdutoDao();
                Produto produto = produtoDao.buscar(id_produto, 1)
                        
                Date data = rs.getDate("data");
                Double desconto = rs.getDouble("desconto");
                String tipo_saida = rs.getString("tipo_saida");

                Saida saida = new Saida(id, produto, data, desconto, tipo_saida);
                
                saidaEncontrada.add(saida);
            }
            rs.close();
            stmt.close();
            return saidaEncontrada;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

}
