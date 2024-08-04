package controlador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import view.CadastrarServico;

public class ServicoController {
    private CadastrarServico view;

    public ServicoController(CadastrarServico view) {
        this.view = view;
        initController();
    }

    private void initController() {
        view.getSalvarButton().addActionListener(e -> mostrarDataHora());
    }
    
     private void mostrarDataHora() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHoraFormatada = agora.format(formatter);
        view.getDataHoraLabel().setText("Data e Hora: " + dataHoraFormatada);
    }
}
