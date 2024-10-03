package br.com.seguradora.service;

import br.com.seguradora.model.seguros.CarroEnum;

public interface IPrecificacaoCarro {
    public abstract void definirPrecoPorIdade(int idade);
    double valorSeguroPorCarro(CarroEnum carro);
}
