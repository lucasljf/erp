/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import modelo.Fornecedor;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FornecedorDAOTest {

    @Test
    public void testAlterarStatus() {
        
        Fornecedor fornecedor = new Fornecedor("NOME", "TELEFONE", "CNPJ", "EMAIL");
        FornecedorDAO dao = new FornecedorDAO();

        Boolean novoStatus = true; 
        Boolean alteracaoStatus = dao.alterarStatus(fornecedorInserido, novoStatus);

        assertTrue(alteracaoStatus);
    }
}
