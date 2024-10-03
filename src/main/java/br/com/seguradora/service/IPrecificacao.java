package br.com.seguradora.service;

import br.com.seguradora.model.seguros.CarroEnum;

public interface IPrecificacao {
    double valorSeguroPorCarro(CarroEnum carro);
}
