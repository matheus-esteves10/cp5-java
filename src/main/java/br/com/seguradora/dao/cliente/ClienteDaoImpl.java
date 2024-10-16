package br.com.seguradora.dao.cliente;

import br.com.seguradora.model.cliente.Cliente;
import br.com.seguradora.service.ICliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDaoImpl implements IClienteDao{

    private final Connection connection;

    public ClienteDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (id, nome, cpf, isAtivo, dataNasc, idade) VALUES (?, ?, ?, ?, ?,?)";

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

    @Override
    public List<Cliente> readAll() {
        String sql = "SELECT * FROM CLIENTE";
        List<Cliente> clientes = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente(
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getInt("isAtivo") == 1,
                        resultSet.getDate("dataNasc").toLocalDate(),
                        resultSet.getInt("idade")
                );
                clientes.add(cliente);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    @Override
    public void update(Cliente cliente) {
        String sql = "UPDATE CLIENTE SET nome = ?, cpf = ?, isAtivo = ?, dataNasc = ?, idade =? WHERE id = ?";

        try{
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setInt(3, cliente.isAtivo() ? 1 : 0);
            statement.setDate(4, java.sql.Date.valueOf(cliente.getDataNasc()));
            statement.setInt(5, cliente.getIdade());
            statement.setLong(6, cliente.getId());
            statement.executeUpdate();
            statement.close();
            System.out.println("Cliente atualizado com sucesso: " + cliente.getNome());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM CLIENTE WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
            statement.close();
            System.out.println("Cliente removido com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

