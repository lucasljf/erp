package dao;

import java.util.List;
import modelo.Fornecedor;
import static org.junit.jupiter.api.Assertions.*;


public class FornecedorDAOTest {
    
    public void testBuscar() {
        FornecedorDAO dao = new FornecedorDAO();
        
        List <Fornecedor> fornecedores = dao.buscar("Raf", true);
        
        assertNotNull(fornecedores);
        assertFalse(fornecedores.isEmpty());
    
    }
}
