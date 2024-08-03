
package controlador;

import view.CadastrarServico;

public class ServicoController {
    private CadastrarServico view;

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
}
