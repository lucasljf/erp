package modelo;

import java.util.Date;

public class Entrada {

    private int id;
    private Date data;
    private int quantidade;
    private double precoCusto;
    private Fornecedor fornecedor;
    private String lote;
    private Date validade;
    private Produto produto;

    public Entrada(Produto produto, Date data, int quantidade, double precoCusto, Fornecedor fornecedor, String lote, Date validade) {
        this.data = data;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.fornecedor = fornecedor;
        this.lote = lote;
        this.validade = validade;
        this.produto = produto;

    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public void salvarEntrada(Entrada entrada) {

    }
}
