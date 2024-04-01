package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modelo.Produto;
import modelo.Fornecedor;
import modelo.Entrada;

public class EntradaDAO {

    private final Connection conexao = new Conexao().getConexao();

    public boolean alterarStatus(Entrada entrada) {
        String sqlSelect = "SELECT * FROM tb_entrada WHERE id = ?";
        String sqlUpdate = "UPDATE tb_entrada SET status = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, entrada.getId());

            ResultSet rs = stmt.executeQuery();

            int status = rs.getInt("status");

            stmt = this.conexao.prepareStatement(sqlUpdate);
            if (status == 1) {
                stmt.setInt(1, 0);
            } else {
                stmt.setInt(1, 1);
            }
            stmt.setInt(2, entrada.getId());

            stmt.executeUpdate();
            stmt.close();

            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public ArrayList<Entrada> buscar(Produto produto) {
        String sql = "SELECT * FROM tb_entrada WHERE produto_id=?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, produto.getId());

            ResultSet rs = stmt.executeQuery();
            ArrayList<Entrada> entradas = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                Date data = rs.getDate("data");
                int quantidade = rs.getInt("quantidade");
                double precoCusto = rs.getDouble("preco_custo");
                String lote = rs.getString("lote");
                Date validade = rs.getDate("validade");

                int id_fornecedor = rs.getInt("fornecedor_id");

                FornecedorDao fornecedorDao = new FornecedorDao();
                Fornecedor fornecedor = fornecedorDao.buscar(id_fornecedor, 1);

                Entrada entrada = new Entrada(id, data, quantidade, precoCusto, produto, fornecedor, lote, validade);

                entradas.add(entrada);
            }

            rs.close();
            stmt.close();
            return entradas;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
    
    public ArrayList<Entrada> buscar(Fornecedor fornecedor) {
        int fornecedorId = fornecedor.getId();
        String sql = "SELECT * FROM tb_entrada WHERE tb_entrada.fornecedor_id = ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setInt(1, fornecedor.getId());

            ResultSet rs = stmt.executeQuery();
            ArrayList<Entrada> entradas = new ArrayList<>();

            while (rs.next()) {
                int id = rs.getInt("id");
                Date data = rs.getDate("data");
                int quantidade = rs.getInt("quantidade");
                double precoCusto = rs.getDouble("preco_custo");
                String lote = rs.getString("lote");
                Date validade = rs.getDate("validade");
                int id_fornecedor = rs.getInt("fornecedor_id");

                Entrada entrada = new Entrada(id, data, quantidade, precoCusto, produto, fornecedor, lote, validade);

                entradas.add(entrada);
            }

            rs.close();
            stmt.close();
            return entradas;

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}