package controlador;

import dao.EntradaDAO;
import dao.FornecedorDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Entrada;
import modelo.Fornecedor;
import modelo.Produto;

public class EntradaController {

    public List<Entrada> BuscarEntrada(String strFornecedor, String strProduto) {
        
        FornecedorDAO fornecedorDao = new FornecedorDAO();
        Fornecedor fornecedor = fornecedorDao.buscar(strFornecedor);
        
        ProdutoDAO produtoDao = new ProdutoDAO();
        Produto produto = produtoDao.buscar(strProduto);
        
        List<Entrada> buscasEntrada = new ArrayList<>();
        EntradaDAO entradaDAO = new EntradaDAO();

        List<Entrada> entradas = entradaDAO.buscar(fornecedor);

        for (Entrada entrada : entradas) {
            Produto produtoEntrada = entrada.getProduto();
            if (produto == produtoEntrada) {
                buscasEntrada.add(entrada);
            }
        }

        return buscasEntrada;
    }
}
