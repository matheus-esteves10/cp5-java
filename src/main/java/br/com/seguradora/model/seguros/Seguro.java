package br.com.seguradora.model.seguros;

import java.util.HashMap;
import java.util.Map;

public class Seguro{
    protected Map<String, Double> infos;
    protected String tipo;
    protected Double valor;

    public Seguro() {
    }

    public Seguro(Map<String, Double> infos, String tipo, Double valor) {
        this.infos = infos;
        this.tipo = tipo;
        this.valor = valor;
    }

    public Seguro(Map<String, Double> infos) {
        this.infos = infos;
    }

    public Map<String, Double> getInfos() {
        return infos;
    }

}
