package br.com.seguradora.dao.cliente;

import br.com.seguradora.model.cliente.Cliente;

import java.util.List;

public interface IClienteDao {

    void salvar(Cliente cliente);
    List<Cliente> readAll();
    void update(Cliente cliente);
    void delete(Long id);
}
