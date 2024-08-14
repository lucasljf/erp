
package controlador;

import dao.SaidaDAO;
import modelo.Saida;
import java.util.ArrayList;
import java.util.List;

public class SaidaController {

    public List<Object[]> preencherTabela() {
        List<Object[]> dadosTabela = new ArrayList<>();
        SaidaDAO saidaDAO = new SaidaDAO();

        List<Saida> listaSaidas = new ArrayList<>();
        listaSaidas.addAll(saidaDAO.buscar("Venda"));
        listaSaidas.addAll(saidaDAO.buscar("Perca"));

        for (Saida saida : listaSaidas) {
            Object[] linha = {saida.getProduto().getNome(), saida.getTipoSaida(), saida.getData()};
            dadosTabela.add(linha);
        }

        return dadosTabela;
    }
}