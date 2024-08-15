package controlador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import view.CadastrarServico;

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
        view.getVoltarButton().addActionListener(e -> voltarTela());
        view.getSalvarButton().addActionListener(e -> mostrarDataHora());
    }

    private void limparCampos() {
        view.getNomeField().setText("");
        view.getDescricaoArea().setText("");
        view.getGarantiaField().setText("");
    }

    private void voltarTela() {
        ConsultarServico consultarServico = new ConsultarServico();
        consultarServico.setVisible(true);
        
        view.dispose();
    }
    
    private void mostrarDataHora() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = agora.format(formatter);
        view.getDataHoraLabel().setText("Data e Hora: " + dataHoraFormatada);
    }
}
