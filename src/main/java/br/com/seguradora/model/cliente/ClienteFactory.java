package br.com.seguradora.model.cliente;

import br.com.seguradora.model.seguros.Seguro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteFactory {
    public static Cliente gerarCliente() {
        List<Seguro> listaSeguros = new ArrayList<>();
        return new Cliente(1L,"Tiago","11111111111",true,listaSeguros, LocalDate.of(1990, 5, 25),19);
    }
}
