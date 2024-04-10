package dao;

import java.util.Date;
import modelo.Entrada;
import modelo.Fornecedor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntradaDAOTest {

    @Test
    public void testAlterarStatus() {
        
        //preparação
        Fornecedor fornecedor = new Fornecedor();        
        Entrada e1 = new Entrada(new Date(2024, 01, 03), 1, 12.5, fornecedor, "JB2334DDJFRR5", new Date(2024, 02, 01));
        EntradaDAO dao = new EntradaDAO();
        e1 = dao.salvar(e1);
        
        //ação
        Boolean statusAlterado = dao.alterarStatus(e1);
        
        assertTrue(statusAlterado);
        
    }
}
