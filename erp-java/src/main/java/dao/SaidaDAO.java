package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Saida;

public class SaidaDAO {
    private list<Saida> listaSaidas;

    public SaidaDAO() {
        this.listaSaidas = new Arraylist<>();
    }
    
    //Método para buscar saída
    
    public void salvar(Saida saida){
        listaSaidas.add(saida);
        System.out.println("Saída salva com sucesso");
    }
}

