package controlador;

import dao.EntradaDAO;
import dao.FornecedorDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Entrada;
import modelo.Fornecedor;
import modelo.Produto;

public class EntradaController {
    
    public boolean cadastrarEntrada(Produto produto, Date data, int quantidade, double precoCusto, Fornecedor fornecedor, String lote, Date validade) {
        if (fornecedor != null && lote != null && validade != null && produto != null) {
            Entrada entrada = new Entrada(produto, data, quantidade, precoCusto, fornecedor, lote, validade);
            Entrada.salvarEntrada(entrada);
            return true;
        }
        return false;
    }
    public List<Entrada> BuscarEntrada(String strFornecedor, Date inicio, Date fim) {
        
        FornecedorDAO fornecedorDao = new FornecedorDAO();
        Fornecedor fornecedor = fornecedorDao.buscar(strFornecedor);
        
        List<Entrada> buscasEntrada = new ArrayList();
        EntradaDAO entradaDAO = new EntradaDAO();

        List<Entrada> entradas = entradaDAO.buscar(fornecedor);

        for (Entrada entrada : entradas) {
            Date dataEntrada = entrada.getData();
            if (dataEntrada.after(inicio) && dataEntrada.before(fim)) {
                buscasEntrada.add(entrada);
            }
        }

        return buscasEntrada;
    }
    
    public List<Entrada> BuscarEntrada(String strFornecedor, String strProduto, Date inicio, Date fim) {
        
        FornecedorDAO fornecedorDao = new FornecedorDAO();
        Fornecedor fornecedor = fornecedorDao.buscar(strFornecedor);
        
        ProdutoDAO produtoDao = new ProdutoDAO();
        Produto produto = produtoDao.buscar(strProduto);
        
        List<Entrada> buscasEntrada = new ArrayList<>();
        EntradaDAO entradaDAO = new EntradaDAO();

        List<Entrada> entradas = entradaDAO.buscar(fornecedor);

        for (Entrada entrada : entradas) {
            Date dataEntrada = entrada.getData();
            Produto produtoEntrada = entrada.getProduto();
            if (dataEntrada.after(inicio) && dataEntrada.before(fim) && produto == produtoEntrada) {
                buscasEntrada.add(entrada);
            }
        }

        return buscasEntrada;
    }
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
