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
                "oracle.fiap.com.br",
                "RM554694",
                "030906"
        );

        Connection connection = config.getConnection();

        ICliente c1 = new ClienteFactory().gerarCliente();
        IClienteDao clienteDao = new ClienteDaoImpl(connection);

//        clienteDao.create((Cliente) c1);
//        List<Cliente> listaClientes = clienteDao.readAll();
//        for (Cliente cliente : listaClientes) {
//            System.out.println(cliente.toString());
//        }
//        ((Cliente) c1).setNome("Gabriel");
//        clienteDao.update((Cliente) c1);
//        clienteDao.delete(((Cliente) c1).getId());

        ISeguro s1 = SeguroFactory.getSeguro("SeguroCarro");
        ISeguroDao seguroDao = new SeguroDaoImpl(connection);

//        seguroDao.create((Seguro) s1);
//        List<Seguro> listaSeguros = seguroDao.readAll();
//        for (Seguro seguro : listaSeguros) {
//            System.out.println(seguro.toString());
//        }
//        ((Seguro) s1).setTipo("SeguroVida");
//        seguroDao.update((Seguro) s1);
//        seguroDao.delete(((Seguro) s1).getId_cliente());
    }
}
