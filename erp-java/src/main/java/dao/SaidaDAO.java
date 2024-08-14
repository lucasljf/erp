package dao;

import modelo.Produto;
import modelo.Saida;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



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
                Produto produto = produtoDao.buscar(id_produto, 1);
                        
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

    public List<Saida> buscar(Date inicio, Date fim) {
        List<Saida> saidasEncontradas = new ArrayList<>();
        for (Saida saida : listaSaida) {
            Date dataSaida = saida.getData();
            if (dataSaida.after(inicio) && dataSaida.before(fim)) {
                saidasEncontradas.add(saida);
            }
        }
        return saidasEncontradas;
    }

    public Saida salvar(Saida saida) {
        String sql = "INSERT INTO tb_saida (produto, data, desconto, tipoSaida) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, saida.getProduto().getId());
            stmt.setDate(2, saida.getData());
            stmt.setDouble(3, saida.getDesconto());
            stmt.setString(4, saida.getTipoSaida());

            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();

            rs.next();

            saida.setId(rs.getInt(1));

            stmt.close();

        } catch (SQLException e) {
            return saida;
            throw new RuntimeException(e);
        }
    }

    private boolean alterarStatus(Saida saida) {

        String sqlSelect = "SELECT * FROM tb_saida WHERE id = ?";
        String sqlUpdate = "UPDATE tb_saida SET status = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, saida.getId());

            ResultSet rs = stmt.executeQuery();

            int status = rs.getInt("status");

            stmt = this.conexao.prepareStatement(sqlUpdate);
            if (status == 1) {
                stmt.setInt(1, 0);
            } else {
                stmt.setInt(1, 1);
            }
            stmt.setInt(2, saida.getId());

            stmt.executeUpdate();
            stmt.close();

            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
