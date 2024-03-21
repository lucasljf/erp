
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public Connection conectar() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql:// localhost:3306/banco_erp", 
                "root", "123456789");
    }

}