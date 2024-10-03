package br.com.seguradora.model.seguros;

public class SeguroCarro extends Seguro {

    public SeguroCarro(int idade) {
        super(idade);
        this.tipo = "SeguroCarro";
        definirPrecoPorIdade(idade);
    }

    @Override
    public void definirPrecoPorIdade(int idade) {
        if (idade >= 18 && idade <= 26) {
            valor = 1200.0;
        } else if (idade >= 27 && idade <= 49) {
            valor = 900.0;
        } else if (idade >= 50) {
            valor = 700.0;
        } else {
            throw new IllegalArgumentException("Idade inválida para o seguro");
        }

        getInfos().put(tipo, valor);
    }
}



