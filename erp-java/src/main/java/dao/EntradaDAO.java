package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modelo.Produto;
import modelo.Fornecedor;
import modelo.Entrada;

public class EntradaDAO {

    private final Connection conexao = new Conexao().getConexao();

    public Entrada salvar(Entrada entrada) {
        
        String sql = "insert into tb_entrada ( data, quantidade, preco_custo, lote, produto_id, validade, fornecedor_id, status) values (?,?,?,?,?,?,?,?)";


        try {
            PreparedStatement ps = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setDate(1, entrada.getData);
            ps.setInt(2, entrada.getQuantidade);
            ps.setInt(3, entrada.getPrecoCusto);
            ps.setInt(4, entrada.getLote);
            ps.setInt(5, entrada.getProduto().getId());
            ps.setDate(6, entrada.getValidade);
            ps.setInt(7, entrada.getFornecedor().getId());
            ps.setInt(8, 1);

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            ResultSet rs = ps.executeQuery();

            entrada.setId(rs.getInt(1));

            return entrada;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
    
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

                Fornecedor fornecedor = new FornecedorDAO().buscar(id);
                Entrada entrada = new Entrada(data, quantidade, precoCusto, fornecedor, lote, validade);
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

            int id_fornecedor = rs.getInt("fornecedor_id");

            FornecedorDAO fornecedorDao = new FornecedorDao();
            fornecedor = fornecedorDao.buscar(id_fornecedor, 1);

            while (rs.next()) {
                int id = rs.getInt("id");
                Date data = rs.getDate("data");
                int quantidade = rs.getInt("quantidade");
                double precoCusto = rs.getDouble("preco_custo");
                String lote = rs.getString("lote");
                Date validade = rs.getDate("validade");
                int id_produto = rs.getInt("produto_id");

                ProdutoDAO produtoDao = new ProdutoDAO();
                Produto produto = produtoDao.buscar(id_produto, 1);

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

    public List<Entrada> buscar(Date inicio, Date fim) {
        List<Entrada> entradasEncontradas = new ArrayList<>();

        String sql = "SELECT * FROM tb_entrada WHERE data BETWEEN ? AND ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            java.sql.Date inicioSql = new java.sql.Date(inicio.getTime());
            java.sql.Date fimSql = new java.sql.Date(fim.getTime());

            stmt.setDate(1, inicioSql);
            stmt.setDate(2, fimSql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Date data = rs.getDate("data");
                int quantidade = rs.getInt("quantidade");
                double precoCusto = rs.getDouble("preco_custo");
                String lote = rs.getString("lote");
                Date validade = rs.getDate("validade");

                int idFornecedor = rs.getInt("fornecedor_id");
                FornecedorDAO fornecedorDao = new FornecedorDAO();
                Fornecedor fornecedor = fornecedorDao.buscar(idFornecedor, true);

                int idProduto = rs.getInt("produto_id");
                ProdutoDAO produtoDao = new ProdutoDAO();
                Produto produto = produtoDao.buscar(idProduto, true);

                Entrada e = new Entrada(data, quantidade, precoCusto, fornecedor, produto, lote, validade);

                entradasEncontradas.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return entradasEncontradas;
    }
}
