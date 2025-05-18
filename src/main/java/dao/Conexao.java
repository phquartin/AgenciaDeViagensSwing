package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static final String URL = "jdbc:mysql://localhost:3306/agencia_de_viagens_swing";
    public static final String USER = "root";
    public static final String PASS = "root";

    public void conectar() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexão estabelecida com sucesso!");
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao banco de dados." + e.getMessage());
        }
    }

}
