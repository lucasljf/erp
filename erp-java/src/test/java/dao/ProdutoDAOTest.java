package dao;

import modelo.Mercadoria;
import modelo.Produto;
import modelo.Servico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
public class ProdutoDAOTest {
    private ProdutoDAO produtoDAO = new ProdutoDAO();
    @Test
    public void salvarMercadoria(){
        Produto produto = new Mercadoria("Produto", "Descrição do Produto", new Date(), new Date(),
                10, 0.15, false);

        Produto produtoSalvo = produtoDAO.salvar(produto);

        Assertions.assertAll(() -> Assertions.assertEquals("Produto", produtoSalvo.getNome()),
                () -> Assertions.assertEquals(produto.getCriadoEm(), produtoSalvo.getCriadoEm()));
    }

    @Test
    public void salvarServico(){
        Produto produto = new Servico("Produto", "Descrição do Produto", new Date(), new Date(),
                "Garantia");

        Produto produtoSalvo = produtoDAO.salvar(produto);

        Assertions.assertAll(() -> Assertions.assertEquals("Produto", produto.getNome()),
                () -> Assertions.assertEquals(produto.getAtualizadoEm(), produtoSalvo.getAtualizadoEm()));
    }
}
