package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Mercadoria;
import modelo.Produto;
import modelo.Servico;

public class ProdutoDAO {

    private final Connection conexao = new Conexao().getConexao();

    public Produto salvar(Produto produto) {

        try {
            if (produto instanceof Mercadoria) {
                Mercadoria mercadoria = (Mercadoria) produto;

                String sqlSalvarMercadoria = "INSERT INTO tb_produto (nome, descricao, criado_em, atualizado_em, quantidade_minima, porcentagem_lucro, perecivel, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

                PreparedStatement stmt = this.conexao.prepareStatement(sqlSalvarMercadoria, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setString(1, mercadoria.getNome());
                stmt.setString(2, mercadoria.getDescricao());
                stmt.setDate(3, new java.sql.Date(mercadoria.getCriadoEm().getTime()));
                stmt.setDate(4, new java.sql.Date(mercadoria.getAtualizadoEm().getTime()));
                stmt.setDouble(5, mercadoria.getQuantidadeMinima());
                stmt.setDouble(6, mercadoria.getPorcentagemLucro());
                stmt.setBoolean(7, mercadoria.isPerecivel());
                stmt.setObject(8, mercadoria.getStatus());

                stmt.execute();

                ResultSet rs = stmt.getGeneratedKeys();

                produto.setId(rs.getInt(1));

            } else if (produto instanceof Servico) {
                Servico servico = (Servico) produto;

                String sqlSalvarServico = "INSERT INTO tb_produto (nome, descricao, criado_em, atualizado_em, garantia) VALUES (?, ?, ?, ?, ?)";

                PreparedStatement stmt = this.conexao.prepareStatement(sqlSalvarServico);
                stmt.setString(1, servico.getNome());
                stmt.setString(2, servico.getDescricao());
                stmt.setDate(3, new java.sql.Date(servico.getCriadoEm().getTime()));
                stmt.setDate(4, new java.sql.Date(servico.getAtualizadoEm().getTime()));
                stmt.setString(5, servico.getGarantia());

                stmt.execute();

                ResultSet rs = stmt.getGeneratedKeys();

                produto.setId(rs.getInt(1));
            }

            return produto;
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
