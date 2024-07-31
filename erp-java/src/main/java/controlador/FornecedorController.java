package controlador;

import dao.FornecedorDAO;
import java.util.List;
import modelo.Fornecedor;

public class FornecedorController {

    public List<Fornecedor> filtrar(String tipo, String status, String busca) {
        boolean statusF;

        if (status.equals("Ativo") || status.equals("selecionar...")) {
            statusF = true;
        } else {
            statusF = false;
        }

        FornecedorDAO fornecedorDao = new FornecedorDAO();

        if (tipo.equals("ID")) {

            int id = Integer.parseInt(busca);
            Fornecedor fornecedor = null;
            fornecedor = fornecedorDao.buscar(id, statusF);

            if (fornecedor == null) {
                return List.of(fornecedor);
            } else {
                return List.of();
            }
        }

        if (tipo.equals("Nome")) {

            String nome = busca;
            List<Fornecedor> fornecedorNome = fornecedorDao.buscar(nome, statusF);

//            return !fornecedorNome.isEmpty();
        }

        if (tipo.equals("cnpj")) {

            String cnpj = busca;
            Fornecedor fornecedorCnpj = fornecedorDao.buscar(cnpj, statusF);

            if (fornecedorCnpj == null) {
                return List.of(fornecedorCnpj);
            } else {
                return List.of();
            }
        }

        if (tipo.equals("Produto")) {
            int id = Integer.parseInt(busca);

            FornecedorDAO fornecedorDao = new FornecedorDAO();
            fornecedorDao.buscar(id, statusF);
        }

        //return false;
    }
}
