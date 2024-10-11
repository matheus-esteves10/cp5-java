package br.com.seguradora.model.seguros;

public class Seguro {
    protected String tipo;
    protected double valor;

    public Seguro() {
    }

    public Seguro(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }


//
//    public Map<String, Double> getInfos() {
//        return infos;
//    }
}
