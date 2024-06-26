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
