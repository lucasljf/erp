
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

    public ServicoController(CadastrarServico view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getVoltarButton().addActionListener(e -> voltarTela());
    }

    private void voltarTela() {
        ConsultarServico consultarServico = new ConsultarServico();
        consultarServico.setVisible(true);
        
        view.dispose();
    }
}
