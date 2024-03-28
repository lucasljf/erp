package dao;

import modelo.Saida;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SaidaDAOTest {
    @Test
    @DisplayName("Verifica se o resultado das buscas não é vazio")
    public void testBuscar(){
        //Buscar por tipo de saída (Venda, perca, outros).
        SaidaDAO saidaDAO = new SaidaDAO();

        ArrayList<Saida> saidasVenda = new ArrayList<>();
        saidasVenda = saidaDAO.buscar("venda");
        assertFalse(saidasVenda.isEmpty());

        ArrayList<Saida> saidasPerca = new ArrayList<>();
        saidasPerca = saidaDAO.buscar("perca");
        assertFalse(saidasPerca.isEmpty());

        ArrayList<Saida> saidasOutros = new ArrayList<>();
        saidasVenda = saidaDAO.buscar("outros");
        assertFalse(saidasVenda.isEmpty());
    }
}