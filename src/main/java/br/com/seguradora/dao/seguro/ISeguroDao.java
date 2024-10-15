package br.com.seguradora.dao.seguro;

import br.com.seguradora.model.seguros.Seguro;

import java.util.List;

public interface ISeguroDao {
    void create(Seguro s1);

    List<Seguro> readAll();

    void update(Seguro s1);

    void delete(Long id);
}
