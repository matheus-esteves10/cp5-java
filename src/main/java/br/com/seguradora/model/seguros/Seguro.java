package br.com.seguradora.model.seguros;

import java.util.HashMap;
import java.util.Map;

public abstract class Seguro{
    protected Map<String, Double> infos;
    protected String tipo;
    protected Double valor;

    public Seguro(int idade) {
        infos = new HashMap<>();
        definirPrecoPorIdade(idade);
    }

    public Map<String, Double> getInfos() {
        return infos;
    }

    public abstract void definirPrecoPorIdade(int idade);

}
