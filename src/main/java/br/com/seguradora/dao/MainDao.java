package br.com.seguradora.dao;

import br.com.seguradora.config.DatabaseConfig;
import br.com.seguradora.dao.cliente.ClienteDaoImpl;
import br.com.seguradora.dao.cliente.IClienteDao;
import br.com.seguradora.dao.seguro.ISeguroDao;
import br.com.seguradora.dao.seguro.SeguroDaoImpl;
import br.com.seguradora.model.cliente.Cliente;
import br.com.seguradora.model.cliente.ClienteFactory;
import br.com.seguradora.model.seguros.Seguro;
import br.com.seguradora.model.seguros.SeguroFactory;
import br.com.seguradora.service.ICliente;
import br.com.seguradora.service.ISeguro;

import java.sql.Connection;
import java.util.List;

public class MainDao {
    public static void main(String[] args) {
        DatabaseConfig config = DatabaseConfig.getInstance(
                "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
                "RM554694",
                "030906"
        );

        Connection connection = config.getConnection();

        //Cliente criado pela factory
        ICliente c1 = new ClienteFactory().gerarCliente();
        IClienteDao clienteDao = new ClienteDaoImpl(connection);

        //Metodo de Insert
//        clienteDao.create((Cliente) c1);

        //Metodo de ReadAll
//        List<Cliente> listaClientes = clienteDao.readAll();
//        for (Cliente cliente : listaClientes) {
//            System.out.println(cliente.toString());
//        }

        //Metodo para dar Update
//        ((Cliente) c1).setNome("Gabriel");
//        clienteDao.update((Cliente) c1);

        //Ver o update
//        List<Cliente> listaClientes = clienteDao.readAll();
//        for (Cliente cliente : listaClientes) {
//            System.out.println(cliente.toString());
//        }

        //Deletar o Cliente
//        clienteDao.delete(((Cliente) c1).getId());

        ISeguro s1 = SeguroFactory.getSeguro("SeguroCarro");
        ISeguroDao seguroDao = new SeguroDaoImpl(connection);

        //Metodo de Insert
//        seguroDao.create((Seguro) s1);

        //Metodo para readAll
//        List<Seguro> listaSeguros = seguroDao.readAll();
//        for (Seguro seguro : listaSeguros) {
//            System.out.println(seguro.toString());
//        }

        //Metodo para ver o Update
//        ((Seguro) s1).setTipo("SeguroVida");
//        seguroDao.update((Seguro) s1);

        //Ver o Update
//        List<Seguro> listaSeguros = seguroDao.readAll();
//        for (Seguro seguro : listaSeguros) {
//            System.out.println(seguro.toString());
//        }

        //Deletar Seguro
//        ((Seguro) s1).setId(1L);
//        seguroDao.delete(((Seguro) s1).getId());
    }
}
