
package controlador;

import modelo.Servico;
import dao.ProdutoDAO;
import java.sql.SQLException;
import java.util.List;
        
        

public class ServicoController {
    
    public final ProdutoDAO produtoDAO;
    
    public ServicoController(){
        
        this.produtoDAO = new ProdutoDAO();
        
    }
    
    public List<Servico> buscarServicos (String nome, boolean status) throws SQLException{
        return produtoDAO.buscarServicos(nome, status);
    }
    
    
    

}










