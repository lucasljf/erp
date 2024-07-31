
package controlador;

import dao.SaidaDAO;
import modelo.Saida;
import java.util.ArrayList;
import java.util.List;

public class SaidaController {

    public List<Saida> preencherLista() {
        List<Saida> listaSaidas = new ArrayList<>();
        SaidaDAO saidaDAO = new SaidaDAO();

        listaSaidas = saidaDAO.buscarTodas();
        
        return listaSaidas;
    }
}
