package br.com.seguradora.model.seguros;

public class Seguro {
    protected String tipo;
    protected double valor;
    protected Long id_cliente;

    public Seguro() {
    }

    public Seguro(String tipo, double valor, Long id_cliente) {
        this.tipo = tipo;
        this.valor = valor;
        this.id_cliente = id_cliente;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
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

    @Override
    public String toString() {
        return "Seguro{" +
                "tipo='" + tipo + '\'' +
                ", valor=" + valor +
                ", id_cliente=" + id_cliente +
                '}';
    }
}
