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

  public List<Fornecedor> buscar(Produto produto, boolean status) {
    String product_nameString = produto.getNome();
    int status_boolean = status ? 1 : 0;
    List<Fornecedor> Fornecedores = new ArrayList<Fornecedor>();
    String sql =
      "SELECT * FROM tb_fornecedor INNER JOIN tb_produto ON tb_fornecedor.id = tb_produto.fornecedor_id WHERE tb_produto.nome = ? AND tb_fornecedor.status = ?";
    try (
      Connection conn = Conexao.getConnexao();
      PreparedStatement ps = conn.prepareStatement(sql)
    ) {
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
