package br.com.seguradora.model.seguros;

public class SeguroFactory {
        public static Seguro getSeguro(String type) {
            if (type.equalsIgnoreCase("SeguroCarro")) {
                return new SeguroCarro();
            } else if (type.equalsIgnoreCase("SeguroResedencia")) {
                return new SeguroResidencia();
            } else if (type.equalsIgnoreCase("SeguroVida")) {
                return new SeguroVida();
            }
            return null;
        }
    }

