package br.com.seguradora.model.seguros;

import br.com.seguradora.service.ISeguro;
import br.com.seguradora.service.precificacoes.IPrecificacaoVida;

public class SeguroVida extends Seguro implements ISeguro, IPrecificacaoVida {

    private boolean temDoencaPreExistente;
    private boolean praticaEsportesRadicais;

    public SeguroVida(String tipo, double valor, Long idCliente, int idade, boolean temDoencaPreExistente, boolean praticaEsportesRadicais) {
        super(tipo,valor,idCliente);
        retornaValor(idade);
        this.temDoencaPreExistente = temDoencaPreExistente;
        this.praticaEsportesRadicais = praticaEsportesRadicais;
    }


    @Override
    public void define() {
        System.out.println("Seguro de vida");
    }

    @Override
    public void retornaValor(int idade) {
        double preco = 0;

        if (idade >= 0 && idade < 18) {
            preco = 200;
        } else if (idade >= 18 && idade < 35) {
            preco = 350;
        } else if (idade >= 35 && idade < 50) {
            preco = 500;
        } else if (idade >= 50 && idade < 65) {
            preco =  700;
        } else {
            preco = 900;
        }
        if (temDoencaPreExistente) {
            preco *= 1.3; // Aumento de 30% para quem tem doenças preexistentes
        }

        if (praticaEsportesRadicais) {
            preco *= 1.4; // Aumento de 40% para quem pratica esportes radicais
        }

        setTipo("seguroVida");
        setValor(preco);
    }
}
