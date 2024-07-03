package dao;

import modelo.Saida;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;
import modelo.Mercadoria;
import modelo.Produto;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class SaidaDAOTest {
    
    @Test
    public void testBuscar() {
        Date data = new Date();
        Mercadoria produto = new Mercadoria("Coca-Cola",
                "Refrigerante lata 350ml",
                data, data, 12D, 30D, true
        );
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        //pegando o Id do produto persistido
        produto = produtoDAO.salvar(produto);
        
        SaidaDAO saidaDAO = new SaidaDAO();
        ArrayList<Saida> saidas = new ArrayList<>();
        
        Saida saidaVenda = new Saida(0,produto, data, 0, "venda");
        Saida saidaPerca = new Saida(0,produto, data, 0, "perca");
        Saida saidaOutros = new Saida(0,produto, data, 0, "outros");
        
        saidaDAO.salvar(saidaVenda);
        saidas.addAll(saidaDAO.buscar("venda"));
        

        saidaDAO.salvar(saidaPerca);
        saidas.addAll(saidaDAO.buscar("perca"));
        
        saidaDAO.salvar(saidaOutros);
        saidas.addAll(saidaDAO.buscar("outros"));
        
        assertFalse(saidas.isEmpty());
        assertEquals(3, saidas.size());
    }
}
