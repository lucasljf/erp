package modelo;

import java.util.Date;

public class Servico extends Produto{
    private String garantia;
    
    
    /*
    * @AllArgsConstructor chama o construtor da super classe @Produto,
    * atribui os valores passados via parâmetro aos respectivos atributos
    * herdados e logo em seguida ao atributo garantia da subclasse
    */
    public Servico (String nome, String descricao,
            Date criadoEm, Date atualizadoEm,
            String garantia)
        {
        super(nome, descricao, criadoEm, atualizadoEm);
        this.garantia = garantia;     
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }   
}
