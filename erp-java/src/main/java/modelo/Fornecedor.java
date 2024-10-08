package modelo;

/**
 *
 * @author kaick
 */
public class Fornecedor {
    private int id;
    private String nome;
    private String telefone;
    private String cnpj;
    private String email;

    //Construtor vazio
    public Fornecedor(){}

    //Construtor com todos os campos
    public Fornecedor(int id, String nome, String telefone, String cnpj, String email) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.email = email;
    }

    //Construtor com todos os campos, exceto ID
    public Fornecedor(String nome, String telefone, String cnpj, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.email = email;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public Fornecedor(String nomel) {
        this.nome = nome;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStatus() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
