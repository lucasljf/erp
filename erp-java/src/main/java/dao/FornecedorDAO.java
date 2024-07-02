package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Fornecedor;
import modelo.Produto;

public class FornecedorDAO {

    private final Connection conexao = new Conexao().getConexao();

    public Fornecedor salvar(Fornecedor fornecedor) {
        String sql = "INSERT INTO fornecedor (nome, telefone, cnpj, email) VALUES (?, ?, ?, ?)";

        try {
            try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
                stmt.setString(1, fornecedor.getNome());
                stmt.setString(2, fornecedor.getTelefone());
                stmt.setString(3, fornecedor.getCnpj());
                stmt.setString(4, fornecedor.getEmail());
                stmt.execute();
            }

        } catch (SQLException e) {
            throw new RuntimeException();

        }

        return fornecedor;
    }

    public boolean alterarStatus(Fornecedor fornecedor) {
        String sqlSelect = "SELECT * FROM tb_fornecedor WHERE id = ?";

        String sqlUpdate = "UPDATE tb_fornecedor WHERE id = ? SET status = ?";
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, fornecedor.getId());

            ResultSet rs = stmt.executeQuery();

            int status = rs.getInt("status");

            stmt = this.conexao.prepareStatement(sqlUpdate);
            stmt.setInt(1, fornecedor.getId());

            if (status == 1) {
                stmt.setInt(2, 0);
            } else {
                stmt.setInt(2, 1);
            }
            stmt.execute();
            stmt.close();

            return true;
        } catch (SQLException exception) {
            return false;
        }
    }

    public Fornecedor buscar(int id, boolean status) {
        Fornecedor fornecedor = null;

        try {
            String sql = "SELECT * FROM tb_fornecedor WHERE id = ? AND status = ?";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.setBoolean(2, status);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Fornecedor f = new Fornecedor(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("telefone"),
                                rs.getString("cnpj"),
                                rs.getString("email")
                        );
                    }
                    rs.close();
                }
                 stmt.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return fornecedor;

    }

    public List<Fornecedor> buscar(String nome, boolean status) {
        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            String sql = "SELECT * FROM tb_fornecedor WHERE nome LIKE ? AND status = ?";
            try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
                stmt.setString(1, "%" + nome + "%");
                stmt.setBoolean(2, status);

                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        Fornecedor f = new Fornecedor(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("telefone"),
                                rs.getString("cnpj"),
                                rs.getString("email")
                        );

                        fornecedores.add(f);
                    }
                    rs.close();
                }
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return fornecedores;
    }

    public Fornecedor buscarPorCnpj(String cnpj, boolean status) {
        Fornecedor fornecedor = null;

        try {
            String sql = "SELECT * FROM tb_fornecedor WHERE cnpj = ? AND status = ?";
            try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
                stmt.setString(1, cnpj);
                stmt.setBoolean(2, status);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        Fornecedor f = new Fornecedor(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("telefone"),
                                rs.getString("cnpj"),
                                rs.getString("email")
                        );
                        rs.close();
                    }
                }
                stmt.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return fornecedor;

    }

    public List<Fornecedor> buscar(Produto produto, boolean status) {
        String product_nameString = produto.getNome();
        int status_boolean = status ? 1 : 0;
        List<Fornecedor> Fornecedores = new ArrayList<>();
        String sql
                = "SELECT * FROM tb_fornecedor INNER JOIN tb_produto ON tb_fornecedor.id = tb_produto.fornecedor_id WHERE tb_produto.nome = ? AND tb_fornecedor.status = ?";
        try (
                PreparedStatement ps = this.conexao.prepareStatement(sql)) {
            ps.setString(1, product_nameString);
            ps.setInt(2, status_boolean);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("telefone"),
                        rs.getString("cnpj"),
                        rs.getString("email")
                );
                Fornecedores.add(f);
                rs.close();
            }
            return Fornecedores;
        } catch (SQLException e) {
            return Fornecedores;
        }
    }

}
