package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/agencia_de_viagens_swing";
    private static final String USER = "root";
    private static final String PASS = "root";

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Falha ao conectar ao banco de dados." + e.getMessage());
        }
    }

}
