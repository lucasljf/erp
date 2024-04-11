/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package dao;

import java.time.LocalDate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import modelo.Entrada;
import modelo.Fornecedor;
import modelo.Mercadoria;
import modelo.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aluno
 */
public class ProdutoDAOTest {
    
    public ProdutoDAOTest() {
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
    
    @Test
    public void buscarTest(){

        LocalDate data = LocalDate.now();
        
        Fornecedor f1 = new Fornecedor(0, "Robervaldo","62 1111-4444", "5151515151515", "jorge amado"); 
        Fornecedor f2 = new Fornecedor(0, "Francisco","62 1111-5444", "515151515151", "Abelardo");
        
        Mercadoria mercadoria1 = new Mercadoria("Coca-Cola", "Refrigerante", Date.valueOf(data.toString()), Date.valueOf(data.toString()), 10.0, 25.0, true);
        Mercadoria mercadoria2 = new Mercadoria("Néctar", "Vitamina de Pequi", Date.valueOf(data.toString()), Date.valueOf(data.toString()), 10.0, 25.0, true);
        
        Entrada entrada1 = new Entrada(mercadoria2, Date.valueOf(data.toString()), 50, 25.99, f1, "13", Date.valueOf(data.toString()));
        Entrada entrada2 = new Entrada(mercadoria1, Date.valueOf(data.toString()), 50, 5.99, f2, "13", Date.valueOf(data.toString()));
        Entrada entrada3 = new Entrada(mercadoria1, Date.valueOf(data.toString()), 50, 25.99, f1, "13", Date.valueOf(data.toString()));
        
        EntradaDAO dao = new EntradaDAO();
        
        dao.salvar(entrada1);
        dao.salvar(entrada2);
        
        List<Fornecedor> fornecedores = new ArrayList();
        
        ProdutoDAO produtoDao = new ProdutoDAO();
        fornecedores = produtoDao.buscar("Coca-Cola", true);
        Assertions.assertFalse(fornecedores.isEmpty());
        Assertions.assertTrue(fornecedores.size() == 2);
        
        fornecedores.clear();
        
        fornecedores = produtoDao.buscar("Balinha de Menta", true);
        Assertions.assertTrue(fornecedores.isEmpty());
        
        fornecedores.clear();
         
        fornecedores = produtoDao.buscar("Coca-Cola", false);
        Assertions.assertFalse(fornecedores.isEmpty());
        
        fornecedores.clear();
        
        fornecedores = produtoDao.buscar("Balinha de Menta", false);
        Assertions.assertTrue(fornecedores.isEmpty());
        
        //
    }
}

   