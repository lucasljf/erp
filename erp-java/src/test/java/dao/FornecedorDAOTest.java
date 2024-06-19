package dao;

import modelo.Fornecedor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class FornecedorDAOTest {
   
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
    
    

