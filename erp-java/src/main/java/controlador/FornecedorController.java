package controlador;

import dao.FornecedorDAO;
import java.util.List;
import modelo.Fornecedor;

public class FornecedorController {
    private FornecedorDAO fornecedorDAO;

    public FornecedorController() {
        this.fornecedorDAO = new FornecedorDAO();
    }

    public List<Fornecedor> buscar(String nome, boolean status) {
        return fornecedorDAO.buscar(nome, status);
    }

}
