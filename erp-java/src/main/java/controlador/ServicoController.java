
package controlador;


import java.util.Date;
import java.util.List;
import java.sql.SQLException;

import dao.ProdutoDAO;
import modelo.Produto;
import modelo.Servico;
import view.CadastrarServico;
        
        

public class ServicoController {
    private CadastrarServico view;
    public final ProdutoDAO produtoDAO;

    public ServicoController(CadastrarServico view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getLimparButton().addActionListener(e -> limparCampos());
    }

    private void limparCampos() {
        view.getNomeField().setText("");
        view.getDescricaoArea().setText("");
        view.getGarantiaField().setText("");
    }

    public ServicoController(){
        
        this.produtoDAO = new ProdutoDAO();
        
    }

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
    
    
    public List<Servico> buscarServicos (String nome, boolean status) throws SQLException{
        return produtoDAO.buscarServicos(nome, status);
    }
}










