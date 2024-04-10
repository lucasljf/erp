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
        // Criar um fornecedor para testar
        Fornecedor fornecedor = new Fornecedor("NOME", "TELEFONE", "CNPJ", "EMAIL");
        FornecedorDAO dao = new FornecedorDAO();

        // Alterar o status do fornecedor para testar
        Boolean novoStatus = true; // Por exemplo, vamos alterar o status para verdadeiro
        Boolean alteracaoStatus = dao.alterarStatus(fornecedorInserido, novoStatus);

        // Verificar se a alteração de status foi bem-sucedida
        assertTrue(alteracaoStatus);
    }
}
