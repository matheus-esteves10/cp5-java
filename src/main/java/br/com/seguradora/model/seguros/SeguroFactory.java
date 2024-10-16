package br.com.seguradora.model.seguros;

import br.com.seguradora.service.ISeguro;

public class SeguroFactory {
    public static ISeguro getSeguro(String type) {
        if (type.equalsIgnoreCase("seguroCarro")) {
            return new SeguroCarro("seguroCarro",0,1L, CarroEnum.CARRO1, 20); // Retorna o tipo ISeguro
        } else if (type.equalsIgnoreCase("seguroResidencia")) {
            return new SeguroResidencia("seguroResidencia",0,1L,15000, true, false, true, false, 1990);
        } else if (type.equalsIgnoreCase("SeguroVida")) {
            return new SeguroVida("seguroVida",0,1L,18,false,false);
        }
        return null;
    }
}

