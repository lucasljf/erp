
package controlador;

import dao.SaidaDAO;
import dao.ProdutoDAO;
import modelo.Saida;
import modelo.Produto;
import java.util.ArrayList;
import java.util.List;

public class SaidaController {   
    
    public List<Saida> buscarPorFiltros(String nome, String tipoFiltro, String tipoFiltroTexto, Date dataInicio, Date dataFim) {
        
        List<Saida> listaFiltrada = new ArrayList<>();
        SaidaDAO saidaDAO = new SaidaDAO();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        switch (tipoFiltro) {
            case "Produto":
                ArrayList<Produto> produtos = produtoDAO.buscar(nome, true);
                if (produtos != null) {
                    for (Produto produto : produtos) {
                        listaFiltrada.addAll(saidaDAO.buscar(produto));
                    }
                }
                break;
            case "Tipo":
                listaFiltrada = saidaDAO.buscar(tipoFiltroTexto);
                break;
            case "Data":
                listaFiltrada = saidaDAO.buscar(dataInicio, dataFim);
                break;
            default:
                listaFiltrada = saidaDAO.buscarTodas();
                break;
        }
        
        return listaFiltrada;
    }
}