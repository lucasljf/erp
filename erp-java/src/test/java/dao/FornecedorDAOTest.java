/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import java.util.List;
import modelo.Fornecedor;
import modelo.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mario
 */
public class FornecedorDAOTest {
    
    public FornecedorDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of salvar method, of class FornecedorDAO.
     */
    @Test
    public void testSalvar() {
        System.out.println("salvar");
        Fornecedor fornecedor = null;
        FornecedorDAO instance = new FornecedorDAO();
        Fornecedor expResult = null;
        Fornecedor result = instance.salvar(fornecedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of alterarStatus method, of class FornecedorDAO.
     */
    @Test
    public void testAlterarStatus() {
        System.out.println("alterarStatus");
        Fornecedor fornecedor = null;
        FornecedorDAO instance = new FornecedorDAO();
        boolean expResult = false;
        boolean result = instance.alterarStatus(fornecedor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class FornecedorDAO.
     */
    @Test
    public void testBuscar_int_boolean() {
        System.out.println("buscar");
        int id = 0;
        boolean status = false;
        FornecedorDAO instance = new FornecedorDAO();
        Fornecedor expResult = null;
        Fornecedor result = instance.buscar(id, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class FornecedorDAO.
     */
    @Test
    public void testBuscar_String_boolean() {
        System.out.println("buscar");
        String nome = "";
        boolean status = false;
        FornecedorDAO instance = new FornecedorDAO();
        List<Fornecedor> expResult = null;
        List<Fornecedor> result = instance.buscar(nome, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class FornecedorDAO.
     */
    @Test
    public void testBuscar_Produto_boolean() {
        System.out.println("buscar");
        Produto produto = null;
        boolean status = false;
        FornecedorDAO instance = new FornecedorDAO();
        List<Fornecedor> expResult = null;
        List<Fornecedor> result = instance.buscar(produto, status);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
