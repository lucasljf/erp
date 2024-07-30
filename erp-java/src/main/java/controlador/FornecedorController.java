
package controlador;

import modelo.Produto;
import view.BuscarFornecedor;
import dao.FornecedorDAO;

public class FornecedorController {

    public boolean filtrar(String tipo, String status, String busca){
        boolean statusF;
        
        if(status.equals("Ativo") || status.equals("selecionar...")){
            statusF = true;
        } else {
            statusF = false;
        }
        
        if(tipo.equals("ID")){
            int id = Integer.parseInt(busca);
            
            FornecedorDAO fornecedorDao = new FornecedorDAO();
            fornecedorDao.buscar(id, statusF);
        }
        
        if(tipo.equals("Nome")){
            String nome = busca;
            
            FornecedorDAO fornecedorDao = new FornecedorDAO();
            fornecedorDao.buscar(nome, statusF);
        }
        
        if(tipo.equals("cnpj")){
            String cnpj = busca;
            
            FornecedorDAO fornecedorDao = new FornecedorDAO();
            fornecedorDao.buscar(cnpj, statusF);
        }
        
        if(tipo.equals("Produto")){
            int id = Integer.parseInt(busca);
            
            FornecedorDAO fornecedorDao = new FornecedorDAO();
            fornecedorDao.buscar(id, statusF);
        }
        
        return false;
    }
    
}
