package br.com.seguradora.model.seguros;

import java.util.HashMap;
import java.util.Map;

public class Seguro {
    protected String tipo;
    protected double valor;
    protected Map<String, Double> infos;

    public Seguro() {
        this.infos = new HashMap<>();
    }

    public Map<String, Double> getInfos() {
        return infos;
    }
}
