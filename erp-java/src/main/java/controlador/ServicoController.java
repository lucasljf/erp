
package controlador;

import view.CadastrarServico;

public class ServicoController {
     private CadastrarServico view;

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
