package dao;

import modelo.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FornecedorDAO {
    private final Connection conexao = new Conexao().getConexao();

    public boolean alterarStatus(Fornecedor fornecedor){
        String sqlSelect = "SELECT * FROM tb_fornecedor WHERE id = ?";

        String sqlUpdate = "UPDATE tb_fornecedor WHERE id = ? SET status = ?";
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sqlSelect);
            stmt.setInt(1, fornecedor.getId());

            ResultSet rs = stmt.executeQuery();

            int status = rs.getInt("status");

            stmt = this.conexao.prepareStatement(sqlUpdate);
            stmt.setInt(1, fornecedor.getId());

            if(status == 1){
                stmt.setInt(2, 0);
            } else {
                stmt.setInt(2, 1);
            }
            stmt.execute();
            stmt.close();

            return true;
        } catch (Exception exception){
            return false;
        }
    }

    public Fornecedor buscar(String cnpj, boolean status) {
        Fornecedor fornecedor = null;
    
    try {
        String sql = "SELECT * FROM tb_fornecedor WHERE cnpj = ? AND status = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, cnpj);
        stmt.setBoolean(2, status);

        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            fornecedor = new Fornecedor();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setNome(rs.getString("nome"));
            fornecedor.setTelefone(rs.getString("telefone"));
            fornecedor.setCnpj(rs.getString("cnpj"));
            fornecedor.setEmail(rs.getString("email"));
        }

        rs.close();
        stmt.close();
    } catch (Exception e) {
            System.out.println(e);
        }

    return fornecedor;
}
}

