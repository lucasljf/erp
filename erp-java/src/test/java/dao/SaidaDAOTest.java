package dao;
import org.junit.jupiter.api.*;
import modelo.Produto;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Mercadoria;
import modelo.Saida;
import org.junit.jupiter.api.Test;

public class SaidaDAOTeste{
    public Connection mockConnettion;
    public Preparedstatement mockPreparedstatement;
    public Resultset mockResultset;
    public SaidaDAO saidaDAO;

    public SaidaDAOTest() {
    }
    
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

    @Test
    public void buscarPorPeriodo(){
        Date data = new Date("04/05/2024");
        Mercadoria produto1 = new Mercadoria(
                "Coca-cola", 
                "Refrigerante sabor cola 2L",
                data, data,
                20,
                15,
                true
        );        
        Mercadoria produto2 = new Mercadoria(
                "Arroz", 
                "Arroz 5kg",
                data, data,
                20,
                15,
                false
        );
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.salvar(produto1);
        produtoDAO.salvar(produto2);  
        
        Saida saida = new Saida();
        saida.setData(new Date("15/06/2024"));
        saida.setDesconto(0);
        saida.setProduto(produto1);
        saida.setTipoSaida("venda");
        
        SaidaDAO saidaDAO = new SaidaDAO();
        saidaDAO.salvar(saida);
        
        saida.setData(new Date("09/06/2024"));
        saida.setDesconto(0);
        saida.setProduto(produto2);
        saida.setTipoSaida("venda");
        
        saidaDAO.salvar(saida);
        
        Date dataInicio = new Date("10/06/2024");
        Date dataFinal = new Date("10/07/2024"); 
        List<Saida> saidas = new ArrayList<>();
        saidas.addAll(saidaDAO.buscar(dataInicio, dataFinal));
        
        assertFalse(saidas.isEmpty());
        assertEquals(1, saidas.size());
    }
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
public class SaidaDAOTest {

    @InjectMocks
    private SaidaDAO saidaDAO;

    @Mock
    private Connection conexaoMock;

    @Mock
    private PreparedStatement stmtMock;

    @Mock
    private ResultSet rsMock;

    @BeforeEach
    public void setup() throws SQLException {
        Mockito.when(conexaoMock.prepareStatement(Mockito.anyString(), Mockito.eq(PreparedStatement.RETURN_GENERATED_KEYS)))
               .thenReturn(stmtMock);
        Mockito.when(stmtMock.getGeneratedKeys()).thenReturn(rsMock);
        Mockito.doNothing().when(stmtMock).setInt(Mockito.anyInt(), Mockito.anyInt());
        Mockito.doNothing().when(stmtMock).setDate(Mockito.anyInt(), Mockito.any());
        Mockito.doNothing().when(stmtMock).setDouble(Mockito.anyInt(), Mockito.anyDouble());
        Mockito.doNothing().when(stmtMock).setString(Mockito.anyInt(), Mockito.anyString());
        Mockito.when(rsMock.next()).thenReturn(true);
        Mockito.when(rsMock.getInt(1)).thenReturn(1);
    }

    @Test
    public void testSalvar() throws SQLException {
        // Criação da instância de Saida para o teste
        Saida saida = new Saida();
        saida.setId(1); // Simulando um ID já atribuído, por exemplo

        // Chama o método a ser testado
        Saida resultado = saidaDAO.salvar(saida);

        // Verificações
        Mockito.verify(stmtMock).execute();
        Mockito.verify(stmtMock).close();
        Mockito.verify(rsMock).next();
        Mockito.verify(rsMock).getInt(1);

        // Asserções
        assertNotNull(resultado);
        assertEquals(saida.getId(), resultado.getId());
    }
}
