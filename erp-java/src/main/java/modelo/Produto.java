package modelo;

import java.util.Date;

public abstract class Produto {
    private int id;
    private String nome;
    private String descricao;
    private Date criadoEm;
    private Date atualizadoEm;

   
    public Produto(String nome, String descricao, Date criadoEm, Date atualizadoEm) {
        this.nome = nome;
        this.descricao = descricao;
        this.criadoEm = new Date(); 
        this.atualizadoEm = new Date(); 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(Date criadoEm) {
        this.criadoEm = criadoEm;
    }

    public Date getAtualizadoEm() {
        return atualizadoEm;
    }

    public void setAtualizadoEm(Date atualizadoEm) {
        this.atualizadoEm = atualizadoEm;
    }
}
