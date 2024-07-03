package dao;

import modelo.Mercadoria;
import modelo.Produto;
import modelo.Servico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import modelo.Entrada;
import modelo.Fornecedor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;
public class ProdutoDAOTest {
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    @Test
    public void salvarMercadoria(){
        Produto produto = new Mercadoria("Produto", "Descrição do Produto", new Date(), new Date(),
                10, 0.15, false);

        Produto produtoSalvo = produtoDAO.salvar(produto);

        Assertions.assertAll(() -> Assertions.assertEquals("Produto", produtoSalvo.getNome()),
                () -> Assertions.assertEquals(produto.getCriadoEm(), produtoSalvo.getCriadoEm()));
    }

    @Test
    public void salvarServico(){
        Produto produto = new Servico("Produto", "Descrição do Produto", new Date(), new Date(),
                "Garantia");

        Produto produtoSalvo = produtoDAO.salvar(produto);

        Assertions.assertAll(() -> Assertions.assertEquals("Produto", produto.getNome()),
                () -> Assertions.assertEquals(produto.getAtualizadoEm(), produtoSalvo.getAtualizadoEm()));
    }
    
    @Test
    public void buscarTest(){

        LocalDate data = LocalDate.now();
        
        Fornecedor f1 = new Fornecedor(0, "Robervaldo","62 1111-4444", "5151515151515", "jorge amado"); 
        Fornecedor f2 = new Fornecedor(0, "Francisco","62 1111-5444", "515151515151", "Abelardo");
        
        Mercadoria mercadoria1 = new Mercadoria("Coca-Cola", "Refrigerante", Date.valueOf(data.toString()), Date.valueOf(data.toString()), 10.0, 25.0, true);
        Mercadoria mercadoria2 = new Mercadoria("Néctar", "Vitamina de Pequi", Date.valueOf(data.toString()), Date.valueOf(data.toString()), 10.0, 25.0, true);
        
        Entrada entrada1 = new Entrada(mercadoria2, Date.valueOf(data.toString()), 50, 25.99, f1, "13", Date.valueOf(data.toString()));
        Entrada entrada2 = new Entrada(mercadoria1, Date.valueOf(data.toString()), 50, 5.99, f2, "13", Date.valueOf(data.toString()));
        Entrada entrada3 = new Entrada(mercadoria1, Date.valueOf(data.toString()), 50, 25.99, f1, "13", Date.valueOf(data.toString()));
        
        EntradaDAO dao = new EntradaDAO();
        
        dao.salvar(entrada1);
        dao.salvar(entrada2);
        
        List<Fornecedor> fornecedores = new ArrayList();
        
        ProdutoDAO produtoDao = new ProdutoDAO();
        fornecedores = produtoDao.buscar("Coca-Cola", true);
        Assertions.assertFalse(fornecedores.isEmpty());
        Assertions.assertTrue(fornecedores.size() == 2);
        
        fornecedores.clear();
        
        fornecedores = produtoDao.buscar("Balinha de Menta", true);
        Assertions.assertTrue(fornecedores.isEmpty());
        
        fornecedores.clear();
         
        fornecedores = produtoDao.buscar("Coca-Cola", false);
        Assertions.assertFalse(fornecedores.isEmpty());
        
        fornecedores.clear();
        
        fornecedores = produtoDao.buscar("Balinha de Menta", false);
        Assertions.assertTrue(fornecedores.isEmpty());
    }
    @Test
    public void testAlterarStatus() {
        
        Mercadoria m = new Mercadoria("status produto", "Alterando status do produto", new Date(), new Date(), 10.0, 0.10, false);
        Servico s = new Servico("Status Serviço", "Alterando status do serviço", new Date(), new Date(), "garantia");
        
        ProdutoDAO dao = new ProdutoDAO();
        
        dao.salvar(m);
        dao.salvar(s);
        
        Mercadoria mercadoria = dao.Buscar(1, false);
        Servico servico = dao.buscar(2, false);
        
        assertNotNull(mercadoria.getId(), "Mercadoria não foi registrada no banco");
        assertNotNull(s.getId(), "Serviço não foi registrado no banco");

        Boolean resultado1 = dao.alterarStatus(m);
        Boolean resultado2 = dao.alterarStatus(s);
        
        assertTrue(resultado1, "Não foi possivel alterar o status da mercadoria.");
        assertTrue(resultado2, "Não foi possivel alterar o status do serviço.");
    }
    
  @Test
    public void testBuscar() {

        Mercadoria mercadoria = new Mercadoria("Buscar ProdutoTeste", "Buscar pelo ProdutoTeste", new Date(), new Date(), 10.0, 0.10, false);
        Servico servico = new Servico("Buscar ServiçoTeste", "Buscar pelo ServiçoTeste", new Date(), new Date(), "garantia");

        ProdutoDAO dao = new ProdutoDAO();

        dao.salvar(mercadoria);
        dao.salvar(servico);

        Mercadoria merc = dao.Buscar(1, false);
        Servico serv = dao.buscar(2, false);

        assertNotNull(merc.getId(), "0 resultados para o produto");
        assertNotNull(serv.getId(), "0 resultados para o serviço");   
}
}
