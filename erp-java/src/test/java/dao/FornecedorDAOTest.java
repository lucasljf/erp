package dao;

import modelo.Fornecedor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class FornecedorDAOTest {

    @Test
    public void testSalvar() {
        Fornecedor f = new Fornecedor("Nome TESTE", "Telefone TESTE", "CNPJ TESTE", "Email TESTE");
        FornecedorDAO dao = new FornecedorDAO();

        Fornecedor fornecedorInserido = dao.salvar(f);  

        assertNotNull(fornecedorInserido);
        assertNotEquals(0, fornecedorInserido.getId());

    }

    public void testBuscar() {
        FornecedorDAO dao = new FornecedorDAO();
        
        List <Fornecedor> fornecedores = dao.buscar("Raf", true);
        
        assertNotNull(fornecedores);
        assertFalse(fornecedores.isEmpty());
    
    }

    @Test
    public void testAlterarStatus() {
        
        Fornecedor fornecedor = new Fornecedor("NOME", "TELEFONE", "CNPJ", "EMAIL");
        FornecedorDAO dao = new FornecedorDAO();

        Boolean novoStatus = true; 
        Boolean alteracaoStatus = dao.alterarStatus(fornecedorInserido, novoStatus);

        assertTrue(alteracaoStatus);
    }
   
    @Test
    public void testBuscarCnpjStatus() {
        FornecedorDAO dao = new FornecedorDAO();

        Fornecedor fornecedor = (Fornecedor) dao.buscar("12345678901234", true);

        assertNotNull(fornecedor);

        assertEquals("Fornecedor 1", fornecedor.getNome());
        assertEquals("123456789", fornecedor.getTelefone());
        assertEquals("12345678901234", fornecedor.getCnpj());
        assertEquals("fornecedor1@teste.com", fornecedor.getEmail());
        assertTrue(fornecedor.isStatus());
    }
}
