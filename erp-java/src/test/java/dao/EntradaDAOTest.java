package dao;

import java.util.Date;
import modelo.Entrada;
import modelo.Fornecedor;
import modelo.Produto;
import modelo.Servico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntradaDAOTest {

    @Test
    public void testAlterarStatus() {
        
        //preparação
        Fornecedor fornecedor = new Fornecedor("Fornecedor", "62985126398", "00.123.456/0001-78", "fornecedor@example.com");
        Produto produto = new Servico("Produto", "Produto exemplo", new Date(), new Date(), "1 ano");
        Entrada e1 = new Entrada(new Date(), 1, 12.5, fornecedor, produto, "JB2334DDJFRR5", new Date());
        EntradaDAO dao = new EntradaDAO();
        e1 = dao.salvar(e1);
        
        //ação
        Boolean statusAlterado = dao.alterarStatus(e1);
        
        assertTrue(statusAlterado);
        
    }
}
