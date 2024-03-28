package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import modelo.Fornecedor;

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
}
