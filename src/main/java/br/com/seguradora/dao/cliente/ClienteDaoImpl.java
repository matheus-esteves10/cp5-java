package br.com.seguradora.dao.cliente;

import br.com.seguradora.model.cliente.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ClienteDaoImpl implements IClienteDao{

    private final Connection connection;

    public ClienteDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void salvar(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (id, nome, cpf, is_ativo, dataNasc, idade) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, cliente.getId());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getCpf());
            statement.setInt(4, cliente.isAtivo() ? 1 : 0);
            statement.setDate(5, java.sql.Date.valueOf(cliente.getDataNasc()));
            statement.setInt(6, cliente.getIdade());
            statement.executeUpdate();
            statement.close();
            System.out.println("Cliente salvo com sucesso: " + cliente.getNome());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    