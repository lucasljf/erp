package dao;

import java.util.ArrayList;
import java.util.Date;
import modelo.Entrada;
import modelo.Produto;
import dao.EntradaDAO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntradaDAOTest {
    
    @org.junit.jupiter.api.Test
    public void testBuscar(Produto produto) {
        Produto produto1 = new Produto(1, "Produto 1");
        Produto produto2 = new Produto(2, "Produto 2");
        
        Entrada entrada1 = new Entrada(1, new Date(), 10, 50.0, produto1, fornecedor, "Lote1", new Date());
        Entrada entrada2 = new Entrada(2, new Date(), 20, 60.0, produto1, fornecedor, "Lote2", new Date());
        Entrada entrada3 = new Entrada(3, new Date(), 15, 70.0, produto2, fornecedor, "Lote3", new Date());
        Entrada entrada4 = new Entrada(4, new Date(), 25, 80.0, produto2, fornecedor, "Lote4", new Date());

        ProdutoDao produtoDao = new ProdutoDao();
        produtoDao.salvar(produto1);
        produtoDao.salvar(produto2);

        EntradaDao entradaDao = new EntradaDao();
        entradaDao.salvar(entrada1);
        entradaDao.salvar(entrada2);
        entradaDao.salvar(entrada3);
        entradaDao.salvar(entrada4);

        ArrayList<Entrada> entradas = entradaDao.buscar(produto1);
        
        assertNotNull(entradas); 
    }
}

import modelo.Fornecedor;
import modelo.Servico;
    @Test
    public void testAlterarStatus() {
        
        //preparação
        Fornecedor fornecedor = new Fornecedor("Fornecedor", "62985126398", "00.123.456/0001-78", "fornecedor@example.com");
        Produto produto = new Servico("Produto", "Produto exemplo", new Date(), new Date(), "1 ano");
        Entrada e1 = new Entrada(new Date(), 1, 12.5, fornecedor, produto, "JB2334DDJFRR5", new Date());
        EntradaDAO dao = new EntradaDAO();
        e1 = dao.salvar(e1);
        
        //ação
        Boolean statusAlterado = dao.alterarStatus(e1);
        
        assertTrue(statusAlterado);
        
    }
}
