package br.com.seguradora.dao;

import br.com.seguradora.config.DatabaseConfig;

import java.sql.Connection;

public class MainDao {

    //todo : adicionar as informações do banco
    DatabaseConfig config = DatabaseConfig.getInstance(
            "url",
            "user",
            "password"
    );

    Connection connection = config.getConnection();

}
