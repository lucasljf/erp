/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import modelo.Fornecedor;
import modelo.Entrada;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author samuel
 */
public class EntradaDAOTest {

    @Test
    public void testSalvar() {
        SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date validade;
        try {
            validade = dataFormat.parse("2024-05-04");

            Fornecedor fornecedor = new Fornecedor(1, "Fornecedor Teste", "123456789", "12345678901234", "fornecedor@teste.com");
            
            Entrada entrada = new Entrada(new Date(), 10, 30.0, fornecedor, "Lote123", validade);

            EntradaDAO entradaDAO = new EntradaDAO();
            Entrada entradaSalva = entradaDAO.salvarEntrada(entrada);

            assertNotNull(entradaSalva);
            assertNotEquals(0, entradaSalva.getId());
        } catch (ParseException ex) {
            Logger.getLogger(EntradaDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
