package br.com.seguradora.model.seguros;

import br.com.seguradora.service.ISeguro;
import br.com.seguradora.service.precificacoes.IPecificacaoResidencia;

public class SeguroResidencia extends Seguro implements ISeguro, IPecificacaoResidencia {
    private double preco;
    private double valorResidencia;


    public SeguroResidencia(double valorResidencia) {
        super();
        this.tipo = "SeguroResidencia";
        this.valorResidencia = valorResidencia;
        defineValor(valorResidencia);
    }

    public double getPreco() {
        return preco;
    }

    public double getValorResidencia() {
        return valorResidencia;
    }

    @Override
    public void define() {
        System.out.println("Seguro de residencia");
    }

    @Override
    public void defineValor(double valorResidencia) {
        var valor =  valorResidencia * 0.001;
        getInfos().put("seguroResidencia", valor);
    }

}
