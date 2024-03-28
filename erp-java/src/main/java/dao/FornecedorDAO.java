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
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, fornecedor.getNome());
            stmt.setString(2, fornecedor.getTelefone());
            stmt.setString(3, fornecedor.getCnpj());
            stmt.setString(4, fornecedor.getEmail());

            stmt.execute();
            stmt.close();

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
        } catch (Exception exception) {
            return false;
        }
    }

    public List<Fornecedor> buscar(Produto produto, boolean status) {
        String product_nameString = produto.getNome();
        int status_boolean = status ? 1 : 0;
        List<Fornecedor> Fornecedores = new ArrayList<Fornecedor>();
        String sql
                = "SELECT * FROM tb_fornecedor INNER JOIN tb_produto ON tb_fornecedor.id = tb_produto.fornecedor_id WHERE tb_produto.nome = ? AND tb_fornecedor.status = ?";
        try (
            Connection conn = Conexao.getConnexao(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, product_nameString);
            ps.setInt(2, status_boolean);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Fornecedor f = new Fornecedor();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setTelefone(rs.getString("telefone"));
                f.setCnpj(rs.getString("cnpj"));
                f.setEmail(rs.getString("email"));
                Fornecedores.add(f);
            }
            return Fornecedores;
        } catch (SQLException e) {
            return Fornecedores;
        }
    }
}
