package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static final String SERVIDOR = "jdbc:mysql://localhost:3306/banco_erp"; 
    public static final String USUARIO = "root"; 
    public static final String SENHA = "123456789"; 

    public Connection getConexao() {
        try {
            return DriverManager.getConnection(SERVIDOR, USUARIO, SENHA);
        } catch (SQLException e) {
            System.err.println(e);
        }
        return null;
    }
}