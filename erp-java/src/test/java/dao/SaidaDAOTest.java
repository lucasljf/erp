package dao;


import modelo.Saida;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;


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