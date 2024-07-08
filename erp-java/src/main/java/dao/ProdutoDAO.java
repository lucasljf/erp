package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Mercadoria;
import modelo.Produto;
import modelo.Servico;
import java.sql.Connection;
import java.util.Date;

public class ProdutoDAO {

    private final Connection conexao = new Conexao().getConexao();
    
    public ArrayList<Produto> buscarTodos(boolean status, char tipo){
        ArrayList<Produto> produtos = new ArrayList<>();
        
        String sql = "SELECT * FROM tb_produto WHERE tipo_produto = ? AND status = ?";
        int statusNum = (status) ? 1 : 0;
        if(tipo == 'A'){
            String tipoString = String.valueOf(tipo);
            try{
                PreparedStatement ps = this.conexao.prepareStatement(sql);
                ps.setString(1, tipoString);
                ps.setInt(2, statusNum);
                
                try(ResultSet rs = ps.executeQuery()){
                    while(rs.next()) {
                        Mercadoria mercadoria = new Mercadoria(
                                rs.getString("nome"),
                                rs.getString("descricao"),
                                rs.getDate("criado_em"),
                                rs.getDate("atualizado_em"),
                                rs.getDouble("quantidade_minima"),
                                rs.getDouble("porcentagem_lucro"),
                                status);
                        mercadoria.setId(rs.getInt("id"));
                        produtos.add(mercadoria);
                    }
                }
            }catch(SQLException e){
                System.out.println("Erro: " + e.getMessage());
            }        
        } else {
            String tipoString = String.valueOf(tipo);
            try{
                PreparedStatement ps = this.conexao.prepareStatement(sql);
                ps.setString(1, tipoString);
                ps.setInt(2, statusNum);
                
                try(ResultSet rs = ps.executeQuery()){
                    while(rs.next()) {
                        Servico servico = new Servico(
                                rs.getString("nome"),
                                rs.getString("descricao"),
                                (Date) rs.getDate("criado_em"),
                                (Date) rs.getDate("atualizado_em"),
                                rs.getString("garantia"));
                        produtos.add(servico);
                    }
                }
            }catch(SQLException e){
                System.out.println("Erro: " + e.getMessage());
            }   
        }
        return produtos;
    }

    public ArrayList<Produto> buscar(String nome, boolean status) {
        ArrayList<Produto> produtos = new ArrayList<>();

        String sql = "SELECT * FROM tb_produto WHERE nome LIKE ? AND status = ?";
        int statusNum = (status) ? 1 : 0;

        try {
            PreparedStatement ps = this.conexao.prepareStatement(sql);
            ps.setString(1, "%" + nome + "%");
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
                        mercadoria.setQuantidadeMinima(rs.getInt(
                                "quantidade_minima"));
                        mercadoria.setPorcentagemLucro(rs.getDouble(
                                "porcentagem_lucro"));
                        mercadoria.setPerecivel(rs.getBoolean("perecivel"));

                        produtos.add(mercadoria);

                    } else {
                        Servico servico = (Servico) produto;
                        servico.setGarantia(rs.getString("garantia"));

                        produtos.add(servico);
                    }
                }

            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        } catch (SQLException exception) {
            System.out.println("Erro: " + exception.getMessage());
        }
        return produtos;
    }

    public boolean alterarStatus(Produto produto) {
        int statusAtual, novoStatus;
        boolean statusAlterado = false;
        String sqlSelectStatus = "SELECT status FROM tb_produto WHERE id = ?";
        String sqlUpdateStatus = "UPDATE tb_produto SET status = ? WHERE id = ?";

        try {
            PreparedStatement stmt = this.conexao.prepareStatement(
                    sqlSelectStatus);
            stmt.setInt(1, produto.getId());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                statusAtual = rs.getInt("status");
                novoStatus = (statusAtual == 1) ? 0 : 1;

                stmt = this.conexao.prepareStatement(sqlUpdateStatus);
                stmt.setInt(1, novoStatus);
                stmt.setInt(2, produto.getId());
                stmt.execute();
                stmt.close();
                statusAlterado = true;
            }

        } catch (Exception e) {
            throw new RuntimeException();
        }

        return statusAlterado;

    }

    public Produto buscar(int id, boolean status) {
        String tipoProduto;

        try {
            String sql = "SELECT * FROM tb_produto WHERE id = ? AND status = ?";
            int statusNum = (status) ? 1 : 0;
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, statusNum);

            ResultSet rs = stmt.executeQuery();

            tipoProduto = rs.getString("tipo_produto");

            if (rs.next()) {
                if (tipoProduto.equalsIgnoreCase("M")) {
                    Mercadoria produto = new Mercadoria(
                            rs.getString("nome"),
                            rs.getString("descricao"),
                            (Date) rs.getDate("criado_em"),
                            (Date) rs.getDate("atualizado_em"),
                            rs.getDouble("quantidade_minima"),
                            rs.getDouble("porcentagem_lucro"),
                            rs.getBoolean("perecivel"));

                    return produto;
                } else {
                    Servico produto = new Servico(rs.getString(
                            "nome"), rs.getString("descricao"), rs.getDate(
                            "criado_em"), rs.getDate("atualizado_em"), rs.
                            getString("garantia"));
                    produto.setId(rs.getInt("id"));

                    return produto;
                }
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

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
                stmt.setObject(8, true);

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
