package br.com.seguradora.dao.seguro;

import br.com.seguradora.model.seguros.Seguro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeguroDaoImpl implements ISeguroDao{
    private final Connection connection;

    public SeguroDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Seguro s1) {
        String sql = "INSERT INTO SEGURO(id_cliente,valor,tipoSeguro) VALUES(?,?,?)";
        try{
            PreparedStatement stat = connection.prepareStatement(sql);
            stat.setLong(1,s1.getId_cliente());
            stat.setDouble(2,s1.getValor());
            stat.setString(3,s1.getTipo());

            stat.executeUpdate();

            stat.close();

            System.out.println("Dados inseridos com sucesso!");
        }catch(SQLException e){
            System.out.println("Não foi possível inserir os dados: "+e.getMessage());
        }
    }

    @Override
    public List<Seguro> readAll() {
        String sql = "SELECT * FROM SEGURO";
        List<Seguro> listaSeguros = new ArrayList<>();
        try {
            PreparedStatement stat = connection.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();
            while(rs.next()){
                Seguro seguro = new Seguro(
                        rs.getString("tipoSeguro"),
                        rs.getDouble("valor"),
                        rs.getLong("id_cliente")
                );
                listaSeguros.add(seguro);
            }
            rs.close();
            stat.close();
        }catch (SQLException e){
            System.out.println("Não foi possível buscar os dados: "+e.getMessage());
        }
        return listaSeguros;
    }

    @Override
    public void update(Seguro s1) {
        String sql = "UPDATE SEGURO SET tipoSeguro = ?, valor = ? WHERE id_cliente = ? ";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);

            stat.setString(1,s1.getTipo());
            stat.setDouble(2,s1.getValor());
            stat.setLong(3,s1.getId_cliente());

            stat.executeUpdate();

            stat.close();

            System.out.println("Dados alterados com sucesso!");
        }catch (SQLException e){
            System.out.println("Não foi possível buscar os dados: "+e.getMessage());
        }

    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM SEGURO WHERE id_cliente = ?";
        try {
            PreparedStatement stat = connection.prepareStatement(sql);

            stat.setLong(1,id);

            stat.executeUpdate();

            stat.close();
            System.out.println("Dados deletados com sucesso!");
        }catch (SQLException e){
            System.out.println("Não foi possível buscar os dados: "+e.getMessage());
        }
    }
}
