package br.com.seguradora.model.seguros;

import br.com.seguradora.service.ISeguro;

public class SeguroFactory {
    public static ISeguro getSeguro(String type) {
        if (type.equalsIgnoreCase("SeguroCarro")) {
            return new SeguroCarro(CarroEnum.CARRO1, 20); // Retorna o tipo ISeguro
        } else if (type.equalsIgnoreCase("SeguroResidencia")) {
            return new SeguroResidencia(500000, true, false, true, false, 1990);
        } else if (type.equalsIgnoreCase("SeguroVida")) {
            return new SeguroVida(20);
        }
        return null;
    }
}

