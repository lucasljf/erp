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
