package dao;

import modelo.Fornecedor;
import modelo.Produto;
import modelo.Mercadoria;
import modelo.Servico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntradaDAO {

    public List<Produto> buscar(Fornecedor fornecedor) {
        int fornecedorId = fornecedor.getId();
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM tb_produto WHERE tb_produto.fornecedor_id = ?";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, fornecedorId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String tipo = rs.getString("tipo_produto");
                    Produto p;
                    if ("M".equals(tipo)) {
                        p = new Mercadoria();
                        ((Mercadoria) p).setPorcentagemMinima(rs.getDouble("porcentagem_minima"));
                        ((Mercadoria) p).setPorcentagemLucro(rs.getDouble("porcentagem_lucro"));
                        ((Mercadoria) p).setPerecivel(rs.getBoolean("perecivel"));
                    } else {
                        p = new Servico();
                        ((Servico) p).setGarantia(rs.getString("garantia"));
                    }
                    
                    p.setId(rs.getInt("id"));
                    p.setNome(rs.getString("nome"));
                    p.setDescricao(rs.getString("descricao"));
                    p.setCriadoEm(rs.getDate("criado_em"));
                    p.setAtualizadoEm(rs.getDate("atualizado_em"));
                    p.setTipoProduto(tipo);
                    p.setStatus(rs.getBoolean("status"));
                    produtos.add(p);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}