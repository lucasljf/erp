package dao;

import java.util.ArrayList;
import modelo.Produto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EntradaDAOTest {
    
    @org.junit.jupiter.api.Test
    public void testBuscar() {
        Produto produto = new Produto();
        produto.setId(1); 

        EntradaDAO entradaDAO = new EntradaDAO();

        ArrayList<Entrada> entradas = entradaDAO.buscar(produto);

        assertNotNull(entradas);
        assertFalse(entradas.isEmpty());

        for (Entrada entrada : entradas) {
            assertEquals(produto.getId(), entrada.getProduto().getId());
        }
    }
    
}
