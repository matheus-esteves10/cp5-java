package br.com.seguradora.model.seguros;

import br.com.seguradora.service.IPrecificacao;

public class SeguroCarro extends Seguro implements IPrecificacao {

    private CarroEnum carro;

    public SeguroCarro(int idade, CarroEnum carro) {
        super(idade);
        this.tipo = "SeguroCarro";
        this.carro = carro;
        definirPrecoPorIdade(idade);
    }

    @Override
    public void definirPrecoPorIdade(int idade) {
        // Calcula o valor do seguro baseando-se no carro
        double valorBase = valorSeguroPorCarro(carro);

        if (idade >= 18 && idade <= 26) {
            valor = valorBase + (valorBase * 0.2); // 20% a mais
        } else if (idade >= 27 && idade <= 57) {
            valor = valorBase; // Valor padrão
        } else if (idade >= 58) {
            valor = valorBase + (valorBase * 0.1); // 10% a mais
        } else {
            throw new IllegalArgumentException("Idade inválida para o seguro");
        }

        getInfos().put(tipo, valor);
    }

    @Override
    public double valorSeguroPorCarro(CarroEnum carro) {
        return 0.04 * carro.getValorTabelaFipe();
    }
}





