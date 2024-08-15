
package controlador;

import dao.FornecedorDAO;
import javax.swing.JTextField;
import modelo.Fornecedor;

public class FornecedorController {
    private JTextField nomeField;
    private JTextField telefoneField;
    private JTextField cnpjField;
    private JTextField emailField;

    public FornecedorController(JTextField nomeField, JTextField telefoneField, JTextField cnpjField, JTextField emailField) {
        this.nomeField = nomeField;
        this.telefoneField = telefoneField;
        this.cnpjField = cnpjField;
        this.emailField = emailField;
    }

    public void carregarFornecedor(int id) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor = fornecedorDAO.buscar(id, true); 
        if (fornecedor != null) {
            preencherFormulario(fornecedor);
        } else {
            exibirMensagem("Fornecedor não encontrado!");
        }
    }

    public void preencherFormulario(Fornecedor fornecedor) {
        nomeField.setText(fornecedor.getNome());
        telefoneField.setText(fornecedor.getTelefone());
        cnpjField.setText(fornecedor.getCnpj());
        emailField.setText(fornecedor.getEmail());
    }

    public void salvarFornecedor(int id) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        Fornecedor fornecedor = new Fornecedor(
            id, 
            nomeField.getText(), 
            telefoneField.getText(), 
            cnpjField.getText(), 
            emailField.getText()
        );
        fornecedorDAO.atualizar(fornecedor);
        exibirMensagem("Fornecedor atualizado com sucesso!");
    }

    public void exibirMensagem(String mensagem) {
        
        System.out.println(mensagem);
    }
}