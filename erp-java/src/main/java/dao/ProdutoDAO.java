
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Mercadoria;
import modelo.Produto;
import modelo.Servico;

public class ProdutoDAO {
    
public ArrayList<Produto> buscar(String nome, boolean status) {
        ArrayList<Produto> produtos = new ArrayList<>();
               
        String sql = "SELECT * FROM tb_produto WHERE nome = ? AND status = ?";
        int statusNum = (status) ? 1 : 0;

        try {
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, nome);
            ps.setInt(2, statusNum);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Produto produto;
                    if (rs.getString("tipo_produto").equals("A")) {
                        produto = new Mercadoria();
                    } else {
                        produto = new Servico();
                    }

                    produto.setId(rs.getInt("id"));
                    produto.setNome(rs.getString("nome"));
                    produto.setAtualizadoEm(rs.getDate("atualizado_em"));
                    produto.setCriadoEm(rs.getDate("criado_em"));
                    produto.setDescricao(rs.getString("descricao"));

                    if (produto instanceof Mercadoria) {
                        Mercadoria mercadoria = (Mercadoria) produto;
                        mercadoria.setQuantidadeMinima(rs.getInt("quantidade_minima"));
                        mercadoria.setPorcentagemLucro(rs.getDouble("porcentagem_lucro"));
                        mercadoria.setPerecivel(rs.getBoolean("perecivel"));

                        produtos.add(mercadoria);

                    } else {
                        Servico servico = (Servico) produto;
                        servico.setGarantia(rs.getString("garantia"));

                        produtos.add(servico);
                    }
                }

            } catch (SQLException e) {
                System.out.println("Erro: "+ e.getMessage());
            }
        }catch (SQLException exception){
            System.out.println("Erro: "+ exception.getMessage());
        }
        return produtos;
    }
}
