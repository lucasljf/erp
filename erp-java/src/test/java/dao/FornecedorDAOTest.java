package dao;

import modelo.Fornecedor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sara
 */
public class FornecedorDAOTest {

    @Test
    public void testSalvar() {
        Fornecedor f = new Fornecedor("Nome TESTE", "Telefone TESTE", "CNPJ TESTE", "Email TESTE");
        FornecedorDAO dao = new FornecedorDAO();

        Fornecedor fornecedorInserido = dao.salvar(f);  

        assertNotNull(fornecedorInserido);
        assertNotEquals(0, fornecedorInserido.getId());

    }

}
