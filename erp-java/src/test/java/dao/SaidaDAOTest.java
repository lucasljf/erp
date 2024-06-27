/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aluno
 */
public class SaidaDAOTest {
    
    @test
    public void testAlterarStatusSaida() {
        
        Mercadoria mercadoria = new Mercadoria("Nome do Produto", "Descrição do Produto", new Date(), new Date(), 10.0, 0.10, false);
        Servico servico = new Servico("Nome do Servico", "Descricao do Servico", new Date(), new Date(), "Garantia");
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        produtoDAO.salvar(mercadoria);
        produtoDAO.salvar(servico);
        
        Mercadoria mcd = produtoDAO.Buscar(1, false);
        Servico srv = produtoDAO.Buscar(2, false);
        
        Saida mcd2 = new Saida(mcd, new Date(), 5.0, "Perca");
        Saida srv2 = new Saida(srv, new Date(), 5.0, "Venda");
        
        SaidaDAO saidaDAO = new SaidaDAO();
        
        SaidaDAO.salvar(mcd2);
        SaidaDAO.salvar(srv2);
        
        Boolean resultM = SaidaDAO.alterar(mcd2);
        Boolean resultS = SaidaDAO.alterar(srv2);
        
        assertTrue(resultM, "Status de Saída da Mercadoria NÃO ALTERADO");
        assertTrue(resultS, "Status de Saída do Serviço NÃO ALTERADO");
        
    }
    
}
