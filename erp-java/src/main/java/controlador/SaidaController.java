
package controlador;

import dao.SaidaDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelo.Saida;

public class SaidaController {

    public Map<String, String> buscarSaidaRegistro(String nomeProduto, String tipo) {
        SaidaDAO saidaDAO = new SaidaDAO();
        ArrayList<Saida> saidas = saidaDAO.buscar(tipo);

        for (Saida saida : saidas) {
            if (saida.getProduto().getNome().equalsIgnoreCase(nomeProduto)) {
                Map<String, String> saidaDados = new HashMap<>();
                saidaDados.put("nomeProduto", saida.getProduto().getNome());
                saidaDados.put("tipoSaida", saida.getTipoSaida());
                saidaDados.put("data", saida.getData());
                saidaDados.put("desconto", String.valueOf(saida.getDesconto()));
                return saidaDados;
            }
        }
        return null;
    }
}

