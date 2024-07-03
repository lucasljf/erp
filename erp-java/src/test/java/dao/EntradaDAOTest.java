package dao;

import java.util.ArrayList;
import java.util.Date;
import modelo.Entrada;
import modelo.Produto;
import modelo.Fornecedor;
import modelo.Servico;
import dao.EntradaDAO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Before;
import org.junit.jupiter.api.Test;

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
        Mockito.when(fornecedorDAO.salvar(fornecedorMock)).thenReturn(fornecedorMock);
        Mockito.when(produtoDAO.salvar(servicoMock)).thenReturn(servicoMock);
        Mockito.when(entradaDAO.salvar(entradaMock)).thenReturn(entradaMock);
        
        EntradaDAO entrada = entradaDAO;
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
    @org.junit.jupiter.api.Test
    public void testBuscar(Produto produto) {
        Produto produto1 = new Produto(1, "Produto 1");
        Produto produto2 = new Produto(2, "Produto 2");

        Entrada entrada1 = new Entrada(1, new Date(), 10, 50.0, produto1,
                fornecedor, "Lote1", new Date());
        Entrada entrada2 = new Entrada(2, new Date(), 20, 60.0, produto1,
                fornecedor, "Lote2", new Date());
        Entrada entrada3 = new Entrada(3, new Date(), 15, 70.0, produto2,
                fornecedor, "Lote3", new Date());
        Entrada entrada4 = new Entrada(4, new Date(), 25, 80.0, produto2,
                fornecedor, "Lote4", new Date());

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

    @Test
    public void testAlterarStatus() {

        //preparação
        Fornecedor fornecedor = new Fornecedor("Fornecedor", "62985126398",
                "00.123.456/0001-78", "fornecedor@example.com");
        Produto produto = new Servico("Produto", "Produto exemplo", new Date(),
                new Date(), "1 ano");
        Entrada e1 = new Entrada(new Date(), 1, 12.5, fornecedor, produto,
                "JB2334DDJFRR5", new Date());
        EntradaDAO dao = new EntradaDAO();
        e1 = dao.salvar(e1);

        //ação
        Boolean statusAlterado = dao.alterarStatus(e1);

        assertTrue(statusAlterado);

    }
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

    @Test
    public void testSalvar() {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date validade;
        try {
            validade = dataFormat.parse("2024-05-04");

            Fornecedor fornecedor = new Fornecedor(1, "Fornecedor Teste", "123456789", "12345678901234", "fornecedor@teste.com");
            
            Entrada entrada = new Entrada(new Date(), 10, 30.0, fornecedor, "Lote123", validade);

            EntradaDAO entradaDAO = new EntradaDAO();
            Entrada entradaSalva = entradaDAO.salvarEntrada(entrada);

            assertNotNull(entradaSalva);
            assertNotEquals(0, entradaSalva.getId());
        } catch (ParseException ex) {
            Logger.getLogger(EntradaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
