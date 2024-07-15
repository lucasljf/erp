
package controlador;

import dao.ProdutoDAO;
import java.util.Date;
import modelo.Produto;
import modelo.Servico;

public class ServicoController {
    public boolean cadastrarServico(String nome, String descricao, String garantia) {
        //fazer aqui
        //buscar por nome
        Servico servico = new Servico(nome, descricao, new Date(), new Date(), garantia);
        ProdutoDAO produtoDao = new ProdutoDAO();
        //criar validação de nome
        
        //validacao campos vazios
        if (nome == null || nome.isEmpty() || descricao == null || descricao.isEmpty() || garantia == null || garantia.isEmpty()) {
            return false;
        }
        //Servico servico2 = produtoDao.salvar(servico);
        Servico servico2 = (Servico) produtoDao.salvar(servico);
        System.out.println(servico2.getId());
        //return true;
        
        if (servico2 == null) {
          return false;
        } else {
          return true;
        }
    }
}
