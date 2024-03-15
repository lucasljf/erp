package modelo;

import java.util.Date;

public class Mercadoria extends Produto{
    private double quantidadeMinima;
    private double porcentagemLucro;
    private boolean perecivel;
    
    /*
    * @AllArgsConstructor chama o construtor da super classe @Produto,
    * atribui os valores aos respectivos atributos herdados e logo em seguida
    * aos atributos da subclasse
    */
    public Mercadoria(String nome, String descricao,
            Date criadoEm, Date atualizadoEm,
            double quantidadeMinima,
            double porcentagemLucro,
            boolean perecivel
        ){
        
        super(nome, descricao, criadoEm, atualizadoEm);
        this.quantidadeMinima = quantidadeMinima;
        this.porcentagemLucro = porcentagemLucro;
        this.perecivel = perecivel;
    }
    
    /*
    * @NoArgsConstructor gera uma instância de objeto com valores padrão
    */
    public Mercadoria(){
        
    }

    public double getQuantidadeMinima() {
        return quantidadeMinima;
    }

    public void setQuantidadeMinima(double quantidadeMinima) {
        this.quantidadeMinima = quantidadeMinima;
    }

    public double getPorcentagemLucro() {
        return porcentagemLucro;
    }

    public void setPorcentagemLucro(double porcentagemLucro) {
        this.porcentagemLucro = porcentagemLucro;
    }

    public boolean isPerecivel() {
        return perecivel;
    }

    public void setPerecivel(boolean perecivel) {
        this.perecivel = perecivel;
    }    
}
