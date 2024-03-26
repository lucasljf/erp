
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntradaDAO {

    public Entrada salvar(Entrada entrada) {
        String sql = "insert into tb_entrada ( data, quantidade, preco_custo, lote, produto_id, validade, fornecedor_id, status) values (?,?,?,?,?,?,?,?)";

        try (
                Connection conn = Conexao.getConnexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, entrada.getData);
            ps.setInt(2, entrada.getQuantidade);
            ps.setInt(3, entrada.getPrecoCusto);
            ps.setInt(4, entrada.getLote);
            ps.setInt(4, entrada.getProdutoId);
            ps.setDate(5, entrada.getValidade);
            ps.setInt(6, entrada.getFornecedorId);
            ps.setInt(7, entrada.getStatus);

            ResultSet rs = ps.executeQuery();

            Entrada e = new Entrada();

            e.setId(rs.getInt("id"));
            e.setData(rs.getDate("data"));
            e.setQuantidade(rs.getInt("quantidade"));
            e.setPreco_custo(rs.getInt("preco_custo"));
            e.setLote(rs.getInt("lote"));
            e.setProdutoId(rs.getInt("produto_id"));
            e.setValidade(rs.getDate("validade"));
            e.setFornecedorID(rs.getInt("fornecedor"));
            e.setStatus(rs.getInt("status"));

            return e;
        }
    }
}