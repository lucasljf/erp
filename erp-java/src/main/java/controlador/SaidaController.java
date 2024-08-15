
package controlador;

import dao.ProdutoDAO;
import dao.SaidaDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Produto;
import modelo.Saida;


import dao.SaidaDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelo.Saida;

public class SaidaController {
    
    // @author: Paulo Prado
    private boolean salvarSaida(String nomeProduto, String data, double desconto, String tipoSaida) throws ParseException {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        SaidaDAO saidaDAO = new SaidaDAO();
        boolean resposta = false;

        if (nomeProduto == null || data == null || tipoSaida == null) {
            return resposta;
        }

        ArrayList<Produto> produtos = produtoDAO.buscar(nomeProduto, true);
        if (produtos == null || produtos.isEmpty()) {
            produtos = produtoDAO.buscar(nomeProduto, false);
        }

        if (produtos == null || produtos.isEmpty()) {
            return resposta;
        }

        Produto produto = produtos.get(0); // Considerando o primeiro produto encontrado

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // Correção no formato da data
        Date dataSQL;

        java.util.Date utilDateData = dateFormat.parse(data);
        dataSQL = new java.sql.Date(utilDateData.getTime());

        if (produto != null && dataSQL != null && tipoSaida != null) {
            Saida novaSaida = new Saida(produto, dataSQL, desconto, tipoSaida);
            saidaDAO.salvar(novaSaida);

            if (novaSaida != null) {
                resposta = true;
            }
        }

        return resposta;
    }

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

