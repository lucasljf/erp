package controlador;

import modelo.Entrada;
import modelo.Fornecedor;
import modelo.Produto;
import java.util.Date;

public class EntradaController {

    public boolean cadastrarEntrada(Produto produto, Date data, int quantidade, double precoCusto, Fornecedor fornecedor, String lote, Date validade) {
        if (fornecedor != null && lote != null && validade != null && produto != null) {
            Entrada entrada = new Entrada(produto, data, quantidade, precoCusto, fornecedor, lote, validade);
            return true;
        }
        return false;
    }
}
