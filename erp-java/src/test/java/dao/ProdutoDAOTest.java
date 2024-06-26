
package dao;

import java.util.Date;
import modelo.Mercadoria;
import modelo.Servico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ProdutoDAOTest {
    
    @Test
    public void testAlterarStatus() {
        
        Mercadoria m = new Mercadoria("status produto", "Alterando status do produto", new Date(), new Date(), 10.0, 0.10, false);
        Servico s = new Servico("Status Serviço", "Alterando status do serviço", new Date(), new Date(), "garantia");
        
        ProdutoDAO dao = new ProdutoDAO();
        
        dao.salvar(m);
        dao.salvar(s);
        
        Mercadoria mercadoria = dao.Buscar(1, false);
        Servico servico = dao.buscar(2, false);
        
        assertNotNull(mercadoria.getId(), "Mercadoria não foi registrada no banco");
        assertNotNull(s.getId(), "Serviço não foi registrado no banco");

        
        Boolean resultado1 = dao.alterarStatus(m);
        Boolean resultado2 = dao.alterarStatus(s);
        
        
        assertTrue(resultado1, "Não foi possivel alterar o status da mercadoria.");
        assertTrue(resultado2, "Não foi possivel alterar o status do serviço.");
    }
    
}
