package controlador;

import dao.FornecedorDAO;
import dao.ProdutoDAO;
import java.util.ArrayList;
import java.util.List;
import modelo.Fornecedor;
import modelo.Produto;

public class FornecedorController {
    private FornecedorDAO fornecedorDAO;

    public FornecedorController() {
        this.fornecedorDAO = new FornecedorDAO();
    }

    public List<Fornecedor> buscar(String nome, boolean status) {
        return fornecedorDAO.buscar(nome, status);
    }

    public List<Fornecedor> filtrar(String tipo, String status, String busca) {
        boolean statusF;

        FornecedorDAO fornecedorDao = new FornecedorDAO();
        List<Fornecedor> resultadoFiltro = new ArrayList<>();

        if (status.equals("Ativo") || status.equals("selecionar...")) {
            statusF = true;
        } else {
            statusF = false;
        }

        if (tipo.equals("ID")) {

            int id = Integer.parseInt(busca);
            Fornecedor fornecedor = null;
            fornecedor = fornecedorDao.buscar(id, statusF);

            if (fornecedor != null) {
                resultadoFiltro.add(fornecedor);
            } else {
                return null;
            }
        }

        if (tipo.equals("Nome")) {

            String nome = busca;
            resultadoFiltro = fornecedorDao.buscar(nome, statusF);
        }

        if (tipo.equals("cnpj")) {

            String cnpj = busca;
            Fornecedor fornecedorCnpj = fornecedorDao.buscar(statusF, cnpj);

            if (fornecedorCnpj != null) {
                resultadoFiltro.add(fornecedorCnpj);
            } else {
                return null;
            }
        }

        if (tipo.equals("Produto")) {
            try {
                // Tentar buscar um produto pelo id
                int id = Integer.parseInt(busca);
                ProdutoDAO produtoDao = new ProdutoDAO();

                Produto produto = produtoDao.buscar(id, statusF);

                if (produto != null) {
                    List<Fornecedor> fornecedores = fornecedorDao.buscar(produto, statusF);
                    resultadoFiltro.addAll(fornecedores);
                }

            } catch (NumberFormatException e) {
                // Caso id são seja válido, busca o produto pelo nome
                String produtoNome = busca;
                ProdutoDAO produtoDao = new ProdutoDAO();

                ArrayList<Produto> produtos = produtoDao.buscar(produtoNome, statusF);

                for (Produto produto : produtos) {
                    List<Fornecedor> fornecedores = fornecedorDao.buscar(produto, statusF);
                    resultadoFiltro.addAll(fornecedores);
                }
            }
        }

        return resultadoFiltro;
    }
}
