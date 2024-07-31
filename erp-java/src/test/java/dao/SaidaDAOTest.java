package dao;

import modelo.Saida;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Date;
import modelo.Mercadoria;
import modelo.Produto;

import org.junit.Test;
import org.mockito.MockitoAnnotations;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class SaidaDAOTeste{
    public Connection mockConnettion;
    public Preparedstatement mockPreparedstatement;
    public Resultset mockResultset;
    public SaidaDAO saidaDAO;

    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        saidaDAO = new SaidaDAO();
        saidaDAO.conexao = mockConnection;
    }
    
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

    public void testBuscarProduto() throws SQLException {

        Produto produto = new Produto();

        produto.setId(1);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt(1)).thenReturn(1);
        when(mockResultSet.getDate(2)).thenReturn(new java.sql.Date(System.currentTimeMillis()));
        when(mockResultSet.getDouble(4)).thenReturn(10.0);
        when(mockResultSet.getNString(5)).thenReturn("saìda");

        ArrayList<Saida> saidas = saidaDAO.buscar(produto);

        assertNotNull(saidas);
        assertEquals(1, saidas.size());
        Saida saida = saidas.get(0);
        assertEquals(1, saida.getId());
        assertEquals(produto, saida.getProduto());
        assertEquals(10.0, saida.getDesconto());
        assertEquals("saida", saida.getTipoSaida());
    }
}
