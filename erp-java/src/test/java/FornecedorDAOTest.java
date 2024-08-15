/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import dao.FornecedorDAO;
import modelo.Fornecedor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FornecedorDAOTest {
    
   
    @Test
    public static void testBuscarPorIdEStatus(int id, boolean status) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        Fornecedor fornecedor = fornecedorDAO.buscar(id, status);

        if (fornecedor != null) {
            System.out.println("Fornecedor encontrado:");
            System.out.println("ID: " + fornecedor.getId());
            System.out.println("Nome: " + fornecedor.getNome());
            System.out.println("Telefone: " + fornecedor.getTelefone());
            System.out.println("CNPJ: " + fornecedor.getCnpj());
            System.out.println("Email: " + fornecedor.getEmail());
        } else {
            System.out.println("Fornecedor não encontrado para o ID " + id + " com status " + status);
        }
    }
}

 
