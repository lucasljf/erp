package dao;

import modelo.Mercadoria;
import modelo.Produto;
import modelo.Servico;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class ProdutoDAOTest {
    private ProdutoDAO produtoDAO = new ProdutoDAO();

    @Test
    public void testBuscarMercadorias() {
        // Cria uma mercadoria ativa
        Mercadoria mercadoriaAtiva = new Mercadoria("Produto Ativo", "Descrição do Produto Ativo",
                new Date(), new Date(), 10, 0.15, true);

        // Salva a mercadoria ativa
        Produto produtoSalvoAtivo = produtoDAO.salvar(mercadoriaAtiva);
        // Busca mercadorias ativas
        List<Produto> mercadoriasAtivas = produtoDAO.buscarPorStatus(true);
        // Verifica se a mercadoria ativa está na lista de produtos ativos
        Assertions.assertTrue(mercadoriasAtivas.contains(produtoSalvoAtivo),
                "A mercadoria ativa não foi encontrada na lista de produtos ativos.");

        //----------------------------------------------------------------//

        // Cria uma mercadoria inativa
        Mercadoria mercadoriaInativa = new Mercadoria("Produto Inativo", "Descrição da Mercadoria Inativa",
                new Date(), new Date(), 5, 0.10, false);

        // Salva a mercadoria inativa
        Produto produtoSalvoInativo = produtoDAO.salvar(mercadoriaInativa);
        // Busca mercadorias inativas
        List<Produto> mercadoriasInativas = produtoDAO.buscarPorStatus(false);
        // Verifica se a mercadoria inativa está na lista de produtos inativos
        Assertions.assertTrue(mercadoriasInativas.contains(produtoSalvoInativo),
                "A mercadoria inativa não foi encontrada na lista de produtos inativos.");
    }

        @Test
        public void testBuscarServicosAtivos() {
            // Cria um serviço ativo
            Servico servicoAtivo = new Servico("Produto Ativo", "Descrição do Produto Ativo",
                    new Date(), new Date(), "Garantia");

            // Salva o serviço
            Produto produtoSalvo = produtoDAO.salvar(servicoAtivo);
            // Busca serviços ativos
            List<Produto> servicosAtivos = produtoDAO.buscarPorStatus(true);
            // Verifica se o serviço está na lista de ativos
            Assertions.assertTrue(servicosAtivos.contains(produtoSalvo),
                    "O serviço ativo não foi encontrado na lista de produtos ativos.");
        }

        @Test
        public void testBuscarServicosInativos() {
            // Cria um serviço inativo
            Servico servicoInativo = new Servico("Produto Inativo", "Descrição do Produto Inativo",
                    new Date(), new Date(), "Garantia");

            // Salva o serviço
            Produto produtoSalvo = produtoDAO.salvar(servicoInativo);
            // Busca serviços inativos
            List<Produto> servicosInativos = produtoDAO.buscarPorStatus(false);
            // Verifica se o serviço está na lista de inativos
            Assertions.assertTrue(servicosInativos.contains(produtoSalvo),
                    "O serviço inativo não foi encontrado na lista de produtos inativos.");
        }

}
