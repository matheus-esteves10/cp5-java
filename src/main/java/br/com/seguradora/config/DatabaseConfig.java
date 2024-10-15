package br.com.seguradora.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static DatabaseConfig instance; // Instância única da classe

    private final String url;
    private final String user;
    private final String password;

    private DatabaseConfig(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    // Método público para retornar a única instância
    public static synchronized DatabaseConfig getInstance(String url, String user, String password) {
        if (instance == null) {
            instance = new DatabaseConfig(url, user, password);
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão com o database", e);
        }
    }
}
