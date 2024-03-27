
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntradaDAO {

    public Entrada salvar(Entrada entrada) {
        String sql = "insert into tb_entrada ( data, quantidade, preco_custo, lote, produto_id, validade, fornecedor_id, status) values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = this.conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setDate(1, entrada.getData);
            ps.setInt(2, entrada.getQuantidade);
            ps.setInt(3, entrada.getPrecoCusto);
            ps.setInt(4, entrada.getLote);
            ps.setInt(5, entrada.getProdutoId);
            ps.setDate(6, entrada.getValidade);
            ps.setInt(7, entrada.getFornecedorId);
            ps.setInt(8, entrada.getStatus);

            ResultSet rs = ps.executeQuery();

            entrada.setId(rs.getInt("1"));

            return entrada;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }
}