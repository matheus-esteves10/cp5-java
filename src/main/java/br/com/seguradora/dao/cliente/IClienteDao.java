package br.com.seguradora.dao.cliente;

import br.com.seguradora.model.cliente.Cliente;

import java.util.List;

public interface IClienteDao {

    void salvar(Cliente cliente);
    public List<Cliente> buscarTodos();
    void atualizar(Cliente cliente);
    void deletar(Long id);
}
