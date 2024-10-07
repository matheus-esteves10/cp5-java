package br.com.seguradora.model.seguros;

import br.com.seguradora.service.ISeguro;
import br.com.seguradora.service.precificacoes.IPrecificacaoVida;

public class SeguroVida extends Seguro implements ISeguro, IPrecificacaoVida {
    double valor;

    public SeguroVida(int idade) {
        this.valor = retornaValor(idade);
    }

    public double getValor() {
        return valor;
    }

    @Override
    public void define() {
        System.out.println("Seguro de vida");
    }

    @Override
    public double retornaValor(int idade) {
        if (idade >= 0 && idade < 18) {
            return 200;
        } else if (idade >= 18 && idade < 35) {
            return 350;
        } else if (idade >= 35 && idade < 50) {
            return 500;
        } else if (idade >= 50 && idade < 65) {
            return 700;
        } else {
            return 900;
        }
    }
}
