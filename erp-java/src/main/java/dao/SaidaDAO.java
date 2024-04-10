package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Produto;
import modelo.Saida;

public class SaidaDAO {

    private final Connection conexao = new Conexao().getConexao();

    public ArrayList<Saida> buscar(Produto produto) throws SQLException {

        String sql = "SELECT * FROM tb_saida WHERE produto_id = ?";
        ArrayList<Saida> produtoSaida = new ArrayList<>();

        try {

            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getId());
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Saida saida = new Saida();
                saida.setId(rs.getInt(1));
                saida.setData(rs.getDate(2));
                saida.setProduto(produto);
                saida.setDesconto(rs.getDouble(4));
                saida.setTipoSaida(rs.getNString(5));
                produtoSaida.add(saida);

            }
  
            return produtoSaida;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
