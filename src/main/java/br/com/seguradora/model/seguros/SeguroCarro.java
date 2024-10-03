package br.com.seguradora.model.seguros;

import br.com.seguradora.service.IPrecificacaoCarro;

public class SeguroCarro extends Seguro implements IPrecificacaoCarro {

    private CarroEnum carro;
    private int idade;

    public SeguroCarro() {}

    public SeguroCarro(CarroEnum carro, int idade) {
        this.tipo = "SeguroCarro";
        this.carro = carro;
        this.idade = idade;
        definirPrecoPorIdade(idade);
    }

    @Override
    public void definirPrecoPorIdade(int idade) {
        if (idade < 0) {
            throw new IllegalArgumentException("Idade inválida para o seguro");
        }

        double valorBase = valorSeguroPorCarro(carro);
        if (idade >= 18 && idade <= 26) {
            valor = valorBase + (valorBase * 0.2); // 20% a mais
        } else if (idade >= 27 && idade <= 57) {
            valor = valorBase; // Valor padrão
        } else if (idade >= 58) {
            valor = valorBase + (valorBase * 0.1); // 10% a mais
        }

        getInfos().put(tipo, valor);
    }

    @Override
    public double valorSeguroPorCarro(CarroEnum carro) {
        if (carro == null) {
            throw new IllegalArgumentException("Carro não pode ser nulo");
        }
        return 0.04 * carro.getValorTabelaFipe();
    }
}





