package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Entrada;
import modelo.Fornecedor;
import modelo.Produto;

public class EntradaDAO {
    
   private Connection conexao = new Conexao().getConexao();
   
	public List<Entrada> buscar(Date inicio, Date fim){
	List<Entrada> entradasEncontradas = new ArrayList<>();

	String sql = "SELECT * FROM tb_entrada WHERE data BETWEEN ? AND ?";

    
    	try {
        	PreparedStatement stmt = this.conexao.prepareStatement(sql);
                java.sql.Date inicioSql = new java.sql.Date(inicio.getTime());
                java.sql.Date fimSql = new java.sql.Date(fim.getTime());
                
        	stmt.setDate(1,  inicioSql);
        	stmt.setDate(2, fimSql);
       	 
        	ResultSet rs = stmt.executeQuery();
        	while (rs.next()) {
                Date data = rs.getDate("data");
                int quantidade = rs.getInt("quantidade");
                double precoCusto = rs.getDouble("preco_custo");
                String lote = rs.getString("lote");
                Date validade = rs.getDate("validade");

                int idFornecedor = rs.getInt("fornecedor_id");
                FornecedorDAO fornecedorDao = new FornecedorDAO();
                Fornecedor fornecedor = fornecedorDao.buscar(idFornecedor, true);
                
                int idProduto = rs.getInt("produto_id");
                ProdutoDAO produtoDao = new ProdutoDAO();
                Produto produto = produtoDao.buscar(idProduto, true);                

                Entrada e = new Entrada(data, quantidade, precoCusto, fornecedor, produto, lote, validade);

            	entradasEncontradas.add(e);
        	}
                
    	} catch(Exception e) {
            e.printStackTrace();
        }
   	 
    	return entradasEncontradas;
	}
}
