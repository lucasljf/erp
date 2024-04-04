package dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import modelo.Entrada;
import modelo.Fornecedor;
import modelo.Produto;
import modelo.Servico;

public class EntradaDAOTest {

    private FornecedorDAO fornecedorDAO;
    private Fornecedor fornecedorMock;
    private ProdutoDAO produtoDAO;
    private Servico servicoMock;
    private EntradaDAO entradaDAO;
    private Entrada entradaMock;

    @Before
    public void setUp() {
        fornecedorDAO = new FornecedorDAO();

        fornecedorMock = mock(Fornecedor.class);
        when(fornecedorMock.getNome()).thenReturn("Fornecedor de Teste");
        when(fornecedorMock.getCnpj()).thenReturn("12345678901234");
        when(fornecedorMock.getTelefone()).thenReturn("62985401985");
        when(fornecedorMock.getEmail()).thenReturn("nupros@mail.com");

        
        produtoDAO = new ProdutoDAO();
        LocalDate data = LocalDate.now();

        servicoMock = mock(Servico.class);
        when(servicoMock.getId()).thenReturn(1);
        when(servicoMock.getNome()).thenReturn("servico de Teste");
        when(servicoMock.getDescricao()).thenReturn("Descrição de Teste");
        when(servicoMock.getCriadoEm()).thenReturn(Date.valueOf(data));
        when(servicoMock.getAtualizadoEm()).thenReturn(Date.valueOf(data));
        when(servicoMock.getGarantia()).thenReturn("3 meses");

        
        entradaDAO = new EntradaDAO();
        
        entradaMock = mock(Entrada.class);
        when(entradaMock.getData()).thenReturn(Date.valueOf(data));
        when(entradaMock.getQuantidade()).thenReturn(10);
        when(entradaMock.getPrecoCusto()).thenReturn(100.0);
        when(entradaMock.getProduto()).thenReturn(servicoMock);
        when(entradaMock.getFornecedor()).thenReturn(fornecedorMock);
        when(entradaMock.getLote()).thenReturn("123456");
        when(entradaMock.getValidade()).thenReturn(Date.valueOf(data));
    }
    
    @Test
    public void testBuscar() {
        fornecedorDAO.salvar(fornecedorMock);
        produtoDAO.salvar(servicoMock);
        entradaDAO.salvar(entradaMock);
        
        EntradaDAO entrada = new EntradaDAO();
        List<Entrada> entradas = entrada.buscar(fornecedorMock);
        
        // Verifica se há pelo menos uma entrada na lista
        assertFalse(entradas.isEmpty(), "Deveria retornar pelo menos uma entrada para o fornecedor fornecido.");
        
        // Verifica se a entrada mockada está presente na lista
        boolean entradaEncontrada = false;
        for (Entrada e : entradas) {
            if (e.equals(entradaMock)) {
                entradaEncontrada = true;
                break;
            }
        }
        assertTrue(entradaEncontrada, "A entrada mockada deveria estar presente na lista.");
    }
}
