package modelo;

import java.util.Date;

/**
 * @author joyce
 */
public class Saida {
    private int id;
    private Produto produto;
    private Date data;
    private double desconto;
    private String tipoSaida;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the Produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the desconto
     */
    public double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the tipoSaida
     */
    public String getTipoSaida() {
        return tipoSaida;
    }

    /**
     * @param tipoSaida the tipoSaida to set
     */
    public void setTipoSaida(String tipoSaida) {
        this.tipoSaida = tipoSaida;
    }
    
    
    
    /* 
        *Instanciando Saída;
        *@author Paulo Prado;
    */
    
    public String saida(Produto produto, Date data, double desconto, String tipoSaida){
        Saida saida = new Saida();
        
        saida.produto = produto;
        saida.data = data;
        saida.desconto = desconto;
        saida.tipoSaida = tipoSaida;
        
        return null;
    }
    
}
