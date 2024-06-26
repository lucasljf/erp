package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Mercadoria;
import modelo.Saida;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SaidaDAOTest {
    
    public SaidaDAOTest() {
    }
    
    @Test
    public void buscarPorPeriodo(){
        Date data = new Date("04/05/2024");
        Mercadoria produto1 = new Mercadoria(
                "Coca-cola", 
                "Refrigerante sabor cola 2L",
                data, data,
                20,
                15,
                true
        );        
        Mercadoria produto2 = new Mercadoria(
                "Arroz", 
                "Arroz 5kg",
                data, data,
                20,
                15,
                false
        );
        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.salvar(produto1);
        produtoDAO.salvar(produto2);  
        
        Saida saida = new Saida();
        saida.setData(new Date("15/06/2024"));
        saida.setDesconto(0);
        saida.setProduto(produto1);
        saida.setTipoSaida("venda");
        
        SaidaDAO saidaDAO = new SaidaDAO();
        saidaDAO.salvar(saida);
        
        saida.setData(new Date("09/06/2024"));
        saida.setDesconto(0);
        saida.setProduto(produto2);
        saida.setTipoSaida("venda");
        
        saidaDAO.salvar(saida);
        
        Date dataInicio = new Date("10/06/2024");
        Date dataFinal = new Date("10/07/2024"); 
        List<Saida> saidas = new ArrayList<>();
        saidas.addAll(saidaDAO.buscar(dataInicio, dataFinal));
        
        assertFalse(saidas.isEmpty());
        assertEquals(1, saidas.size());
    }
}
