
package controlador;

import dao.ProdutoDAO;
import java.util.ArrayList;
import modelo.Produto;

public class MercadoriaController {
    private ProdutoDAO dao;

    
    public ArrayList<Produto> buscarPorNome(String nome, boolean status){
        ArrayList<Produto> produtos = new ArrayList<>();
        produtos.addAll(dao.buscar(nome, status));
        return produtos;
    }
    
    public ArrayList<Produto> buscarTodos(boolean status){
        return dao.buscarTodos(status, 'A');
    }
    
    
    public MercadoriaController() {
        this.dao = new ProdutoDAO();
    }
}
