package br.com.seguradora.model.seguros;

import br.com.seguradora.service.ISeguro;
import br.com.seguradora.service.precificacoes.IPecificacaoResidencia;

public class SeguroResidencia extends Seguro implements ISeguro, IPecificacaoResidencia {
    private double valorResidencia;
    private boolean temSistemaSeguranca;
    private boolean coberturaRoubo;
    private boolean coberturaIncendio;
    private boolean coberturaDesastresNaturais;
    private int anoConstrucao;


    public SeguroResidencia(String tipo, double valor, Long idCliente ,double valorResidencia, boolean temSistemaSeguranca, boolean coberturaRoubo, boolean coberturaIncendio,
                            boolean coberturaDesastresNaturais, int anoConstrucao) {
        super(tipo,valor,idCliente);
        this.valorResidencia = valorResidencia;
        this.temSistemaSeguranca = temSistemaSeguranca;
        this.coberturaRoubo = coberturaRoubo;
        this.coberturaIncendio = coberturaIncendio;
        this.coberturaDesastresNaturais = coberturaDesastresNaturais;
        this.anoConstrucao = anoConstrucao;
        defineValor(valorResidencia);
    }


    public double getValorResidencia() {
        return valorResidencia;
    }

    public boolean isTemSistemaSeguranca() {
        return temSistemaSeguranca;
    }

    public boolean isCoberturaRoubo() {
        return coberturaRoubo;
    }

    public boolean isCoberturaIncendio() {
        return coberturaIncendio;
    }

    public boolean isCoberturaDesastresNaturais() {
        return coberturaDesastresNaturais;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    @Override
    public void define() {
        System.out.println("Seguro de residencia");
    }

    @Override
    public void defineValor(double valorResidencia) {
        var valor =  valorResidencia * 0.001;

        if (temSistemaSeguranca) {
            valor *= 0.9;
        }
        if (anoConstrucao < 1990) {
            valor *= 1.2;
        }
        if (coberturaRoubo) {
            valor += 500;
        }
        if (coberturaIncendio) {
            valor += 300;
        }
        if (coberturaDesastresNaturais) {
            valor += 700;
        }
        setTipo("seguroResidencia");
        setValor(valor);
    }

}
