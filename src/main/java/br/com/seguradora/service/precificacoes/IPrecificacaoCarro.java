package br.com.seguradora.service.precificacoes;

import br.com.seguradora.model.seguros.CarroEnum;

public interface IPrecificacaoCarro {
    void definirPrecoPorIdade(int idade);
    double valorSeguroPorCarro(CarroEnum carro);
}
