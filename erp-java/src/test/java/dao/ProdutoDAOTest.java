package dao;

import modelo.Mercadoria;
import modelo.Servico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Date;
public class ProdutoDAOTest {
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    @Test
    public void salvarMercadoria(){
        Mercadoria produto = new Mercadoria("Produto", "Descrição do Produto", new Date(), new Date(),
                10, 0.15, false);

        Mockito.when(produtoDAO.salvar(produto)).thenReturn(produto);

        Assertions.assertAll(() -> Assertions.assertEquals("Produto", produto.getNome()),
                () -> Assertions.assertFalse(produto.isPerecivel()));
    }

    @Test
    public void salvarServico(){
        Servico produto = new Servico("Produto", "Descrição do Produto", new Date(), new Date(),
                "Garantia");

        Mockito.when(produtoDAO.salvar(produto)).thenReturn(produto);

        Assertions.assertAll(() -> Assertions.assertEquals("Produto", produto.getNome()),
                () -> Assertions.assertEquals("Garantia", produto.getGarantia()));
    }
}
