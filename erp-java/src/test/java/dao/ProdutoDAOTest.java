/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import java.util.Date;
import modelo.Mercadoria;
import modelo.Servico;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProdutoDAOTest {
    
  @Test
    public void testBuscar() {

        Mercadoria mercadoria = new Mercadoria("Buscar ProdutoTeste", "Buscar pelo ProdutoTeste", new Date(), new Date(), 10.0, 0.10, false);
        Servico servico = new Servico("Buscar ServiçoTeste", "Buscar pelo ServiçoTeste", new Date(), new Date(), "garantia");

        ProdutoDAO dao = new ProdutoDAO();

        dao.salvar(mercadoria);
        dao.salvar(servico);

        Mercadoria merc = dao.Buscar(1, false);
        Servico serv = dao.buscar(2, false);

        assertNotNull(merc.getId(), "0 resultados para o produto");
        assertNotNull(serv.getId(), "0 resultados para o serviço");   
}
